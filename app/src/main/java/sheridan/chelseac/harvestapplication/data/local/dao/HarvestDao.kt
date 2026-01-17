package sheridan.chelseac.harvestapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity
import kotlinx.coroutines.flow.Flow

/**
 * DAO = Data Access Object
 * Handles database operations
 */
@Dao
interface HarvestDao {

    @Query("SELECT * FROM harvest ORDER BY harvestDate DESC")
    fun getAllHarvests(): Flow<List<HarvestEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHarvest(harvest: HarvestEntity)

    @Delete
    suspend fun deleteHarvest(harvest: HarvestEntity)

    @Query("DELETE FROM harvest")
    suspend fun clearAll()
}
