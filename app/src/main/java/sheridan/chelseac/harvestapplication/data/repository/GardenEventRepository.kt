package sheridan.chelseac.harvestapplication.data.repository

import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.dao.GardenEventDao
import sheridan.chelseac.harvestapplication.data.local.entity.GardenEventEntity

class GardenEventRepository(
    private val dao: GardenEventDao
) {

    fun getEventsForGarden(gardenId: Int): Flow<List<GardenEventEntity>> =
        dao.getEventsForGarden(gardenId)

    suspend fun addEvent(title: String, date: String, gardenId: Int) {
        dao.insertEvent(
            GardenEventEntity(
                title = title,
                date = date,
                gardenId = gardenId
            )
        )
    }

    suspend fun deleteEvent(event: GardenEventEntity) =
        dao.deleteEvent(event)
}
