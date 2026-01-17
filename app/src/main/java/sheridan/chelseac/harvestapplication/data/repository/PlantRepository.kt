package sheridan.chelseac.harvestapplication.data.repository

import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.PlantDao
import sheridan.chelseac.harvestapplication.data.local.UserGardenWithDetails
import sheridan.chelseac.harvestapplication.data.models.Plant
import sheridan.chelseac.harvestapplication.data.models.UserPlant
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository module for handling data operations. 
 * Graduate Level Concept: Single Source of Truth (SSOT).
 * This class abstracts the data sources (Local/Remote) from the UI layer.
 */
@Singleton
class PlantRepository @Inject constructor(
    private val plantDao: PlantDao
) {

    // --- Botanical Catalog ---

    fun getPlantCatalog(): Flow<List<Plant>> = plantDao.getAllPlants()

    fun getPlant(plantId: String): Flow<Plant> = plantDao.getPlantById(plantId)

    suspend fun populateCatalog(plants: List<Plant>) {
        plantDao.insertPlants(plants)
    }

    // --- User Garden ---

    fun getMyGarden(): Flow<List<UserGardenWithDetails>> = plantDao.getMyGardenWithDetails()

    suspend fun addPlantToGarden(plantId: String, nickName: String) {
        val userPlant = UserPlant(
            plantId = plantId,
            nickName = nickName,
            acquisitionDate = LocalDateTime.now(),
            lastWateredDate = LocalDateTime.now()
        )
        plantDao.addToGarden(userPlant)
    }

    suspend fun removePlantFromGarden(userPlant: UserPlant) {
        plantDao.removeFromGarden(userPlant)
    }

    suspend fun waterPlant(userPlant: UserPlant) {
        val updatedPlant = userPlant.copy(lastWateredDate = LocalDateTime.now())
        plantDao.updatePlantCare(updatedPlant)
    }
}
