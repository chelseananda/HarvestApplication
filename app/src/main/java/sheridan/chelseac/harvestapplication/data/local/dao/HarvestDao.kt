package sheridan.chelseac.harvestapplication.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

@Dao
interface HarvestDao {

    @Query("SELECT * FROM harvests ORDER BY id DESC")
    fun getAllHarvests(): Flow<List<HarvestEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHarvest(harvest: HarvestEntity)

    @Update
    suspend fun updateHarvest(harvest: HarvestEntity)

    @Delete
    suspend fun deleteHarvest(harvest: HarvestEntity)

    @Query("DELETE FROM harvests")
    suspend fun clearAll()
}
