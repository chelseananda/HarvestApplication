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

    // Insert a new harvest item
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHarvest(harvest: HarvestEntity)

    // Get all harvest items (reactive)
    @Query("SELECT * FROM harvest_table ORDER BY id DESC")
    fun getAllHarvests(): Flow<List<HarvestEntity>>

    // Delete all data (for reset/testing)
    @Query("DELETE FROM harvest_table")
    suspend fun deleteAll()
}
