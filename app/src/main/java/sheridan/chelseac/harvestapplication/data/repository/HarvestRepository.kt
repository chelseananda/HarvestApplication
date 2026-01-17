package sheridan.chelseac.harvestapplication.data.repository

import sheridan.chelseac.harvestapplication.data.local.dao.HarvestDao
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity
import kotlinx.coroutines.flow.Flow

/**
 * Repository layer
 * Acts as single source of truth
 */
class HarvestRepository(
    private val harvestDao: HarvestDao
) {

    // Get all harvest items
    val allHarvests: Flow<List<HarvestEntity>> =
        harvestDao.getAllHarvests()

    // Insert a new harvest item
    suspend fun insert(harvest: HarvestEntity) {
        harvestDao.insertHarvest(harvest)
    }

    // Clear database
    suspend fun clearAll() {
        harvestDao.deleteAll()
    }
}
