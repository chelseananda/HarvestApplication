package sheridan.chelseac.harvestapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "plants",
    foreignKeys = [
        ForeignKey(
            entity = GardenEntity::class,
            parentColumns = ["id"],
            childColumns = ["gardenId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("gardenId")]
)
data class PlantEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val gardenId: Int
)
