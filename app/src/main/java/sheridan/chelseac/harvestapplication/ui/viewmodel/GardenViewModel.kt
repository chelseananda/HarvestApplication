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

    // 🔄 DB → UI model mapping
    val gardens: StateFlow<List<Garden>> =
        repository.getAllGardens()
            .map { entities ->
                entities.map {
                    Garden(
                        id = it.id,
                        name = it.name,
                        type = it.type
                    )
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun addGarden(name: String, type: String) {
        viewModelScope.launch {
            repository.addGarden(name, type)
        }
    }

    fun deleteGarden(garden: Garden) {
        viewModelScope.launch {
            repository.deleteGarden(
                garden = sheridan.chelseac.harvestapplication.data.local.entity.GardenEntity(
                    id = garden.id,
                    name = garden.name,
                    type = garden.type
                )
            )
        }
    }
}
