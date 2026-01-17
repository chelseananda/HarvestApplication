package sheridan.chelseac.harvestapplication.ui.state

import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

/**
 * Represents UI state for the Harvest screen
 */
data class HarvestUiState(
    val harvestList: List<HarvestEntity> = emptyList(),
    val isLoading: Boolean = false
)
