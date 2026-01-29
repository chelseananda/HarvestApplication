package sheridan.chelseac.harvestapplication.data.repository

import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.dao.GardenDao
import sheridan.chelseac.harvestapplication.data.local.entity.GardenEntity
import sheridan.chelseac.harvestapplication.data.local.relation.GardenWithPlants

class GardenRepository(
    private val dao: GardenDao
) {

    fun getGardensWithPlants(): Flow<List<GardenWithPlants>> =
        dao.getGardensWithPlants()

    suspend fun addGarden(name: String) {
        dao.insertGarden(
            GardenEntity(name = name)
        )
    }

    suspend fun deleteGarden(gardenId: Int) {
        dao.deleteGardenById(gardenId)
    }
}
