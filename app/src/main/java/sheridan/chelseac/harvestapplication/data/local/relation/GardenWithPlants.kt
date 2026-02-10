package sheridan.chelseac.harvestapplication.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import sheridan.chelseac.harvestapplication.data.local.entity.GardenEntity
import sheridan.chelseac.harvestapplication.data.local.entity.PlantEntity

data class GardenWithPlants(
    @Embedded val garden: GardenEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "gardenId"
    )
    val plants: List<PlantEntity>
)