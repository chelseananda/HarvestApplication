package sheridan.chelseac.harvestapplication.data.repository

import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.dao.HarvestDao
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

class HarvestRepository(
    private val dao: HarvestDao
) {

    fun getAllHarvests(): Flow<List<HarvestEntity>> =
        dao.getAllHarvests()

    suspend fun insertHarvest(harvest: HarvestEntity) =
        dao.insertHarvest(harvest)

    suspend fun updateHarvest(harvest: HarvestEntity) =
        dao.updateHarvest(harvest)

    suspend fun deleteHarvest(harvest: HarvestEntity) =
        dao.deleteHarvest(harvest)

    suspend fun clearAll() =
        dao.clearAll()
}
