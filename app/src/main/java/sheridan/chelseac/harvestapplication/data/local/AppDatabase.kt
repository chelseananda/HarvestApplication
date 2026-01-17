package sheridan.chelseac.harvestapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import sheridan.chelseac.harvestapplication.data.models.Plant
import sheridan.chelseac.harvestapplication.data.models.UserPlant

/**
 * Main Database for the Botanist application.
 * Graduate Level: Using [TypeConverters] for Java 8 Date/Time support.
 */
@Database(
    entities = [Plant::class, UserPlant::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun plantDao(): PlantDao
}
