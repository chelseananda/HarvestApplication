package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.data.local.entity.GardenEventEntity
import sheridan.chelseac.harvestapplication.data.repository.GardenEventRepository
import sheridan.chelseac.harvestapplication.ui.model.GardenEvent

class CalendarViewModel(
    private val repository: GardenEventRepository
) : ViewModel() {

    // Observe events from Room → UI model
    val events: StateFlow<List<GardenEvent>> =
        repository.getAllEvents()
            .map { entities ->
                entities.map {
                    GardenEvent(
                        id = it.id,
                        title = it.title,
                        date = it.date,
                        gardenName = it.gardenName
                    )
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    private var recentlyDeletedEvent: GardenEvent? = null

    fun addEvent(title: String, date: String, gardenName: String) {
        viewModelScope.launch {
            repository.addEvent(title, date, gardenName)
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
                    gardenName = event.gardenName
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
                    gardenName = event.gardenName
                )
                recentlyDeletedEvent = null
            }
        }
    }
}
