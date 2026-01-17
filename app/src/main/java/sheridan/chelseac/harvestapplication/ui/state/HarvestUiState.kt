package sheridan.chelseac.harvestapplication.ui.state

import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

data class HarvestUiState(
    val harvests: List<HarvestEntity> = emptyList()
)