package sheridan.chelseac.harvestapplication.ui.model

//all plants in the garden
data class Plant (
    val id: Int,
    val name: String,
    val sunlight: String,
    val water: String,
    val daysToHarvest: String,
    val description: String
)