package sheridan.chelseac.harvestapplication.data.repository

import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.dao.HarvestDao
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

class HarvestRepository(
    private val harvestDao: HarvestDao
) {

    // Stream of all harvests
    val harvests: Flow<List<HarvestEntity>> =
        harvestDao.getAllHarvests()

    suspend fun insertHarvest(harvest: HarvestEntity) {
        harvestDao.insertHarvest(harvest)
    }

    suspend fun deleteHarvest(harvest: HarvestEntity) {
        harvestDao.deleteHarvest(harvest)
    }
}