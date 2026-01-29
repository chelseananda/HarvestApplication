package sheridan.chelseac.harvestapplication.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "calendar_events",
    foreignKeys = [
        ForeignKey(
            entity = GardenEntity::class,
            parentColumns = ["id"],
            childColumns = ["gardenId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class GardenEventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val date: String,
    val gardenId: Int
)
