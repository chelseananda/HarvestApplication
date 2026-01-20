// ui/viewmodel/GardenViewModel.kt
package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import sheridan.chelseac.harvestapplication.ui.model.Garden

class GardenViewModel : ViewModel() {

    private val _gardens = MutableStateFlow<List<Garden>>(emptyList())
    val gardens: StateFlow<List<Garden>> = _gardens

    private var nextId = 1

    fun addGarden(name: String, type: String) {
        val garden = Garden(
            id = nextId++,
            name = name,
            type = type
        )
        _gardens.value = _gardens.value + garden
    }
}
