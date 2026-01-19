package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import sheridan.chelseac.harvestapplication.ui.model.Plant

class PlantViewModel : ViewModel() {

    private val plants = listOf(
        Plant(
            id = 1,
            name = "Tomato",
            sunlight = "Full Sun",
            water = "2 in / week",
            daysToHarvest = "60–100 days",
            description = "Tomatoes grow best in warm climates and need consistent watering."
        ),
        Plant(
            id = 2,
            name = "Carrot",
            sunlight = "Full Sun",
            water = "1 in / week",
            daysToHarvest = "50–80 days",
            description = "Carrots prefer loose, sandy soil and cooler temperatures."
        ),
        Plant(
            id = 3,
            name = "Basil",
            sunlight = "Partial Sun",
            water = "1–2 in / week",
            daysToHarvest = "30–60 days",
            description = "Basil is a fast-growing herb that thrives in warm weather."
        )
    )

    fun getPlants(): List<Plant> = plants

    fun getPlantById(id: Int): Plant? {
        return plants.find { it.id == id }
    }
}
