package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity
import sheridan.chelseac.harvestapplication.data.repository.HarvestRepository
import sheridan.chelseac.harvestapplication.ui.state.HarvestUiState

class HarvestViewModel(
    private val repository: HarvestRepository
) : ViewModel() {

    // Expose UI state as StateFlow
    private val _uiState = MutableStateFlow(HarvestUiState())
    val uiState: StateFlow<HarvestUiState> = _uiState.asStateFlow()
    init{
        observeHarvests()
    }

    private fun observeHarvests() {
        viewModelScope.launch {
            repository.harvests.collect {
                list -> _uiState.value = HarvestUiState(harvests = list)
            }
        }
    }

    fun addHarvest(name: String, quantity: Int, date: String) {
        viewModelScope.launch {
            repository.insertHarvest(
                HarvestEntity(
                    name = name,
                    quantity = quantity,
                    date = date
                )
            )
        }
    }

    fun deleteHarvest(harvest: HarvestEntity) {
        viewModelScope.launch {
            repository.deleteHarvest(harvest)
        }
    }
}
