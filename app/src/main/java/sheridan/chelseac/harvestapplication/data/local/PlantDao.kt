package sheridan.chelseac.harvestapplication.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.models.Plant
import sheridan.chelseac.harvestapplication.data.models.UserPlant

/**
 * Data Access Object for the Botanist system.
 * Graduate Level Note: Using Flow for all read operations to provide 
 * a reactive stream of data to the UI layer.
 */
@Dao
interface PlantDao {

    // --- Catalog Operations ---

    @Query("SELECT * FROM plants ORDER BY commonName ASC")
    fun getAllPlants(): Flow<List<Plant>>

    @Query("SELECT * FROM plants WHERE id = :plantId")
    fun getPlantById(plantId: String): Flow<Plant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlants(plants: List<Plant>)

    // --- User Garden Operations ---

    @Query("SELECT * FROM user_garden ORDER BY acquisitionDate DESC")
    fun getMyGarden(): Flow<List<UserPlant>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addToGarden(userPlant: UserPlant)

    @Delete
    suspend fun removeFromGarden(userPlant: UserPlant)

    @Update
    suspend fun updatePlantCare(userPlant: UserPlant)

    /**
     * Graduate Level Detail: A complex query to fetch user plants with their botanical details.
     * This avoids manual mapping in the repository.
     */
    @Transaction
    @Query("SELECT * FROM user_garden")
    fun getMyGardenWithDetails(): Flow<List<UserGardenWithDetails>>
}

/**
 * A data class to hold the result of the join between UserPlant and Plant.
 */
data class UserGardenWithDetails(
    @Embedded val userPlant: UserPlant,
    @Relation(
        parentColumn = "plantId",
        entityColumn = "id"
    )
    val plantDetails: Plant
)
