package sheridan.chelseac.harvestapplication.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.entity.PlantEntity

@Dao
interface PlantDao {

    //Get all plants for a specific garden
    @Query("SELECT * FROM plants WHERE gardenId = :gardenId ORDER BY id DESC")
    fun getPlantsForGarden(gardenId: Int): Flow<List<PlantEntity>>

    //Insert a new plant
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlant(plant: PlantEntity)

    //Delete a plant
    @Delete
    suspend fun deletePlant(plant: PlantEntity)

    //Delete all plants for a garden (used if needed)
    @Query("DELETE FROM plants WHERE gardenId = :gardenId")
    suspend fun deletePlantsForGarden(gardenId: Int)
}
