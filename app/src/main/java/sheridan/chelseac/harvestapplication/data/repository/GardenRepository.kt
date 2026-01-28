package sheridan.chelseac.harvestapplication.data.repository

import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.dao.GardenDao
import sheridan.chelseac.harvestapplication.data.local.entity.GardenEntity

class GardenRepository(
    private val dao: GardenDao
) {

    fun getAllGardens(): Flow<List<GardenEntity>> =
        dao.getAllGardens()

    suspend fun addGarden(name: String, type: String) {
        dao.insertGarden(
            GardenEntity(name = name, type = type)
        )
    }

    suspend fun deleteGarden(garden: GardenEntity) =
        dao.deleteGarden(garden)
}
