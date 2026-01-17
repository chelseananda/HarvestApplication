package sheridan.chelseac.harvestapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import sheridan.chelseac.harvestapplication.data.models.Plant
import sheridan.chelseac.harvestapplication.data.repository.PlantRepository
import javax.inject.Inject

/**
 * ViewModel for the Botanical Catalog.
 * Handles the logic for discovering and adding new plants.
 */
@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val repository: PlantRepository
) : ViewModel() {

    init {
        seedDatabase()
    }

    /**
     * Exposes the full list of botanical plants from the database.
     */
    val plantCatalog: StateFlow<List<Plant>> = repository.getPlantCatalog()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    private fun seedDatabase() {
        viewModelScope.launch {
            val samplePlants = listOf(
                Plant(
                    id = "1",
                    commonName = "Snake Plant",
                    scientificName = "Sansevieria trifasciata",
                    description = "Known for its upright leaves and air-purifying qualities.",
                    growthHabitat = "Indirect Sunlight",
                    wateringIntervalDays = 14,
                    imageUrl = "https://images.unsplash.com/photo-1593482892290-f54927ae1bf6?auto=format&fit=crop&q=80&w=1000"
                ),
                Plant(
                    id = "2",
                    commonName = "Monstera Deliciosa",
                    scientificName = "Monstera deliciosa",
                    description = "Iconic heart-shaped leaves with unique natural holes.",
                    growthHabitat = "Partial Shade",
                    wateringIntervalDays = 7,
                    imageUrl = "https://images.unsplash.com/photo-1614594975525-e45190c55d0b?auto=format&fit=crop&q=80&w=1000"
                ),
                Plant(
                    id = "3",
                    commonName = "Fiddle Leaf Fig",
                    scientificName = "Ficus lyrata",
                    description = "A popular indoor tree with large, violin-shaped leaves.",
                    growthHabitat = "Bright, Indirect Light",
                    wateringIntervalDays = 10,
                    imageUrl = "https://images.unsplash.com/photo-1597055148762-3490987c9364?auto=format&fit=crop&q=80&w=1000"
                ),
                Plant(
                    id = "4",
                    commonName = "Aloe Vera",
                    scientificName = "Aloe barbadensis miller",
                    description = "A succulent plant species of the genus Aloe.",
                    growthHabitat = "Direct Sunlight",
                    wateringIntervalDays = 21,
                    imageUrl = "https://images.unsplash.com/photo-1596547609652-9cf5d8d76921?auto=format&fit=crop&q=80&w=1000"
                )
            )
            repository.populateCatalog(samplePlants)
        }
    }

    fun addPlantToGarden(plant: Plant, nickName: String) {
        viewModelScope.launch {
            repository.addPlantToGarden(plant.id, nickName)
        }
    }
}
