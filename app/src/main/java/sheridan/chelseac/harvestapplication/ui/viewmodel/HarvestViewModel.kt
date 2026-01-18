package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.data.local.dao.HarvestDao
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

class HarvestViewModel(
    private val dao: HarvestDao
) : ViewModel() {

    // Observe harvest list from Room
    val harvests = dao.getAllHarvests()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )
    private var recentlyDeletedHarvest : HarvestEntity? = null

    // Add new harvest
    fun addHarvest(name: String, quantity: Int, date: String) {
        viewModelScope.launch {
            dao.insertHarvest(
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
            dao.deleteHarvest(harvest)
        }
    }

    fun undoDelete(){
        recentlyDeletedHarvest?.let {
            viewModelScope.launch {
                dao.insertHarvest(it)
                recentlyDeletedHarvest = null
            }
        }
    }
}
