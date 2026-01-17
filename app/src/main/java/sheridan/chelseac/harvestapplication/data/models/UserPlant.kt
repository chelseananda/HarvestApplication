package sheridan.chelseac.harvestapplication.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDateTime

/**
 * Graduate Level Concept: Relational Integrity.
 * This entity links a user's collection to the master [Plant] catalog.
 * It tracks individual care history using modern [LocalDateTime].
 */
@Entity(
    tableName = "user_garden",
    foreignKeys = [
        ForeignKey(
            entity = Plant::class,
            parentColumns = ["id"],
            childColumns = ["plantId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["plantId"])]
)
data class UserPlant(
    @PrimaryKey(autoGenerate = true) 
    val gardenRecordId: Long = 0,
    val plantId: String,
    val nickName: String,
    val acquisitionDate: LocalDateTime = LocalDateTime.now(),
    val lastWateredDate: LocalDateTime = LocalDateTime.now()
)
