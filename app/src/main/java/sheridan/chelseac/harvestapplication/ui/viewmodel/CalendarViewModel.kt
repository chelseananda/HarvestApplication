package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import sheridan.chelseac.harvestapplication.ui.model.GardenEvent

class CalendarViewModel : ViewModel() {

    private val events = listOf(
        GardenEvent(1, "Water Tomatoes", "Jan 20"),
        GardenEvent(2, "Fertilize Basil", "Jan 23"),
        GardenEvent(3, "Harvest Carrots", "Jan 28")
    )

    fun getEvents(): List<GardenEvent> = events
}
