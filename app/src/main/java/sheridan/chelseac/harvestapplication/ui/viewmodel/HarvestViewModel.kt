package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity
import sheridan.chelseac.harvestapplication.data.repository.HarvestRepository
import sheridan.chelseac.harvestapplication.ui.state.HarvestUiState

/**
 * ViewModel for Harvest screen
 */
class HarvestViewModel(
    private val repository: HarvestRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HarvestUiState())
    val uiState: StateFlow<HarvestUiState> = _uiState.asStateFlow()

    init {
        observeHarvests()
    }

    /**
     * Observe database changes
     */
    private fun observeHarvests() {
        viewModelScope.launch {
            repository.allHarvests.collect { harvests ->
                _uiState.value = _uiState.value.copy(
                    harvestList = harvests,
                    isLoading = false
                )
            }
        }
    }

    /**
     * Add new harvest item
     */
    fun addHarvest(name: String, quantity: Int, date: String) {
        viewModelScope.launch {
            repository.insert(
                HarvestEntity(
                    name = name,
                    quantity = quantity,
                    harvestDate = date
                )
            )
        }
    }

    /**
     * Clear all harvest data
     */
    fun clearAllHarvests() {
        viewModelScope.launch {
            repository.clearAll()
        }
    }
    fun deleteHarvest(harvest: HarvestEntity) {
        viewModelScope.launch {
            repository.delete(harvest)
        }
    }

}
