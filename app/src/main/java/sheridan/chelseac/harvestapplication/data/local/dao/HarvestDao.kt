package sheridan.chelseac.harvestapplication.data.local.dao


import androidx.room.*
import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

/**
 * DAO = Data Access Object
 * Handles database operations for HarvestEntity
 */
@Dao
interface HarvestDao {

    @Query("SELECT * FROM harvest ORDER BY date DESC")
    fun getAllHarvests(): Flow<List<HarvestEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHarvest(harvest: HarvestEntity)

    @Delete
    suspend fun deleteHarvest(harvest: HarvestEntity)

    @Query("DELETE FROM harvest")
    suspend fun clearAll()
}
