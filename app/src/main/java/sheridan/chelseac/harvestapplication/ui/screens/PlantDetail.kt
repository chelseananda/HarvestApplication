package sheridan.chelseac.harvestapplication.ui.screens

import android.health.connect.datatypes.units.Temperature

data class PlantDetail(
    val name: String,
    val category: String,
    val sunlight: String,
    val water: String,
    val temperature: String,
    val description: String
)