package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import sheridan.chelseac.harvestapplication.ui.model.GardenEvent

class CalendarViewModel : ViewModel() {

    private val _events = MutableStateFlow<List<GardenEvent>>(emptyList())
    val events: StateFlow<List<GardenEvent>> = _events

    private var nextId = 1

    fun addEvent(
        title: String,
        date: String,
        gardenName: String
    ) {
        val event = GardenEvent(
            id = nextId++,
            title = title,
            date = date,
            gardenName = gardenName
        )
        _events.value = _events.value + event
    }

    fun deleteEvent(event: GardenEvent) {
        _events.value = _events.value - event
    }
}
