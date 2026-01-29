package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.data.repository.GardenRepository
import sheridan.chelseac.harvestapplication.ui.model.Garden

class GardenViewModel(
    private val repository: GardenRepository
) : ViewModel() {

    val gardens: StateFlow<List<Garden>> =
        repository.getGardensWithPlants()
            .map { relations ->
                relations.map { relation ->
                    Garden(
                        id = relation.garden.id,
                        name = relation.garden.name,
                        plantCount = relation.plants.size
                    )
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun addGarden(name: String) {
        viewModelScope.launch {
            repository.addGarden(name)
        }
    }

    fun deleteGarden(gardenId: Int) {
        viewModelScope.launch {
            repository.deleteGarden(gardenId)
        }
    }
}
