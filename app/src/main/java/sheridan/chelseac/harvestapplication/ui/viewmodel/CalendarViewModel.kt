package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.data.local.entity.GardenEventEntity
import sheridan.chelseac.harvestapplication.data.repository.GardenEventRepository
import sheridan.chelseac.harvestapplication.ui.model.GardenEvent

class CalendarViewModel(
    private val repository: GardenEventRepository
) : ViewModel() {

    private val selectedGardenId = MutableStateFlow<Int?>(null)

    val events: StateFlow<List<GardenEvent>> =
        selectedGardenId
            .filterNotNull()
            .flatMapLatest { gardenId ->
                repository.getEventsForGarden(gardenId)
            }
            .map { entities ->
                entities.map {
                    GardenEvent(
                        id = it.id,
                        title = it.title,
                        date = it.date,
                        gardenId = it.gardenId
                    )
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    private var recentlyDeletedEvent: GardenEvent? = null

    fun selectGarden(gardenId: Int) {
        selectedGardenId.value = gardenId
    }

    fun addEvent(title: String, date: String) {
        val gardenId = selectedGardenId.value ?: return

        viewModelScope.launch {
            repository.addEvent(
                title = title,
                date = date,
                gardenId = gardenId
            )
        }
    }

    fun deleteEvent(event: GardenEvent) {
        viewModelScope.launch {
            recentlyDeletedEvent = event
            repository.deleteEvent(
                GardenEventEntity(
                    id = event.id,
                    title = event.title,
                    date = event.date,
                    gardenId = event.gardenId
                )
            )
        }
    }

    fun undoDelete() {
        recentlyDeletedEvent?.let { event ->
            viewModelScope.launch {
                repository.addEvent(
                    title = event.title,
                    date = event.date,
                    gardenId = event.gardenId
                )
                recentlyDeletedEvent = null
            }
        }
    }
}
