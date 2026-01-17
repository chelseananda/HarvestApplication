package sheridan.chelseac.harvestapplication.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data model representing a botanical entity in our catalog.
 * Graduate Level: Using a unique [id] and scientific classification.
 */
@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey 
    val id: String,
    val commonName: String,
    val scientificName: String,
    val description: String,
    val growthHabitat: String, // e.g., "Full Sun", "Partial Shade"
    val wateringIntervalDays: Int,
    val imageUrl: String = ""
)
