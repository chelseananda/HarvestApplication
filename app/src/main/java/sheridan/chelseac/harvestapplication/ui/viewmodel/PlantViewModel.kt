// ui/viewmodel/PlantViewModel.kt
package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import sheridan.chelseac.harvestapplication.ui.model.Plant

class PlantViewModel : ViewModel() {

    val plants = listOf(
        Plant(
            id = 1,
            name = "Tomato",
            sunlight = "Full Sun",
            water = "2 in/week",
            daysToHarvest = "60–100 days",
            description = "Tomatoes grow best in warm conditions with plenty of sunlight."
        ),
        Plant(
            id = 2,
            name = "Carrot",
            sunlight = "Partial Sun",
            water = "1 in/week",
            daysToHarvest = "70–80 days",
            description = "Carrots prefer loose soil and moderate watering."
        )
    )

    fun getPlantById(id: Int): Plant? {
        return plants.find { it.id == id }
    }
}
