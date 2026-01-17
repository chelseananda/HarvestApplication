package sheridan.chelseac.harvestapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

/**
 * DAO = Data Access Object
 * Handles database operations for HarvestEntity
 */
@Dao
interface HarvestDao {

    @Query("SELECT * FROM harvests ORDER BY id DESC")
    fun getAllHarvests(): Flow<List<HarvestEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHarvest(harvest: HarvestEntity)

    @Delete
    suspend fun deleteHarvest(harvest: HarvestEntity)

    @Query("DELETE FROM harvests")
    suspend fun clearAll()
}
