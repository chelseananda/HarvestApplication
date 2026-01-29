package sheridan.chelseac.harvestapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gardens")
data class GardenEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)
