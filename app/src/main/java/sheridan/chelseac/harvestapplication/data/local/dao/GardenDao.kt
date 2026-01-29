package sheridan.chelseac.harvestapplication.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.entity.GardenEntity
import sheridan.chelseac.harvestapplication.data.local.relation.GardenWithPlants

@Dao
interface GardenDao {

    @Query("SELECT * FROM gardens ORDER BY id DESC")
    fun getAllGardens(): Flow<List<GardenEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGarden(garden: GardenEntity)

    @Query("DELETE FROM gardens WHERE id = :gardenId")
    suspend fun deleteGardenById(gardenId: Int)

    @Transaction
    @Query("SELECT * FROM gardens")
    fun getGardensWithPlants(): Flow<List<GardenWithPlants>>

}
