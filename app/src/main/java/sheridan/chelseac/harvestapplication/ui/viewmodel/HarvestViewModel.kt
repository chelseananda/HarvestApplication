package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity
import sheridan.chelseac.harvestapplication.data.repository.HarvestRepository

class HarvestViewModel(
    private val repository: HarvestRepository
) : ViewModel() {

    // 🌱 Observe harvest list from Room via Repository
    val harvests: StateFlow<List<HarvestEntity>> =
        repository.getAllHarvests()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    private var recentlyDeletedHarvest: HarvestEntity? = null

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
            recentlyDeletedHarvest = harvest
            repository.deleteHarvest(harvest)
        }
    }

    fun undoDelete() {
        recentlyDeletedHarvest?.let { harvest ->
            viewModelScope.launch {
                repository.insertHarvest(harvest)
                recentlyDeletedHarvest = null
            }
        }
    }
}
