package sheridan.chelseac.harvestapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents one harvested item in the database
 */
@Entity(tableName = "harvest_table")
data class HarvestEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Name of crop or harvest item
    val name: String,

    // Quantity harvested (kg, units, etc.)
    val quantity: Int,

    // Date stored as String for simplicity
    val harvestDate: String
)
