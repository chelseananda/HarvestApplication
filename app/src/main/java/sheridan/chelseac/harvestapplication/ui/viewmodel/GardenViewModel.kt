package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import sheridan.chelseac.harvestapplication.ui.model.GardenEvent

class GardenViewModel : ViewModel() {

    private val _gardens = MutableStateFlow<List<GardenEvent>>(emptyList())
    val gardens: StateFlow<List<GardenEvent>> = _gardens

    private var nextId = 1

    fun addGarden(name: String, type: String) {
        val newGardenEvent = GardenEvent(
            id = nextId++,
            name = name,
            type = type
        )
        _gardens.value = _gardens.value + newGardenEvent
    }
}
