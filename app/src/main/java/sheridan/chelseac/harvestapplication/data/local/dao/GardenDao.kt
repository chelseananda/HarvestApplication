package sheridan.chelseac.harvestapplication.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.entity.GardenEntity

@Dao
interface GardenDao {

    @Query("SELECT * FROM gardens ORDER BY id DESC")
    fun getAllGardens(): Flow<List<GardenEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGarden(garden: GardenEntity)

    @Delete
    suspend fun deleteGarden(garden: GardenEntity)
}
