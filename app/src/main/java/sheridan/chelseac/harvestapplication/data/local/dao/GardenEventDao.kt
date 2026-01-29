package sheridan.chelseac.harvestapplication.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.entity.GardenEventEntity

@Dao
interface GardenEventDao {

    @Query(
        "SELECT * FROM calendar_events WHERE gardenId = :gardenId ORDER BY date ASC"
    )
    fun getEventsForGarden(gardenId: Int): Flow<List<GardenEventEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: GardenEventEntity)

    @Delete
    suspend fun deleteEvent(event: GardenEventEntity)
}
