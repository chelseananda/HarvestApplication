package sheridan.chelseac.harvestapplication.data.repository

import kotlinx.coroutines.flow.Flow
import sheridan.chelseac.harvestapplication.data.local.dao.GardenEventDao
import sheridan.chelseac.harvestapplication.data.local.entity.GardenEventEntity

class GardenEventRepository(
    private val dao: GardenEventDao
) {

    fun getAllEvents(): Flow<List<GardenEventEntity>> =
        dao.getAllEvents()

    suspend fun addEvent(title: String, date: String, gardenName: String) {
        dao.insertEvent(
            GardenEventEntity(
                title = title,
                date = date,
                gardenName = gardenName
            )
        )
    }

    suspend fun deleteEvent(event: GardenEventEntity) =
        dao.deleteEvent(event)
}
