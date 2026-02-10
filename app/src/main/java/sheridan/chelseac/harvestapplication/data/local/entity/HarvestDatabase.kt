package sheridan.chelseac.harvestapplication.data.local.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sheridan.chelseac.harvestapplication.data.local.dao.GardenDao
import sheridan.chelseac.harvestapplication.data.local.dao.GardenEventDao
import sheridan.chelseac.harvestapplication.data.local.dao.HarvestDao
import sheridan.chelseac.harvestapplication.data.local.dao.PlantDao

@Database(
    entities = [
        HarvestEntity::class,
        GardenEntity::class,
        GardenEventEntity::class,
        PlantEntity::class
    ],
    version = 4, // ⬅️ bumped version (REQUIRED)
    exportSchema = false
)
abstract class HarvestDatabase : RoomDatabase() {

    abstract fun harvestDao(): HarvestDao
    abstract fun gardenDao(): GardenDao
    abstract fun gardenEventDao(): GardenEventDao
    abstract fun plantDao(): PlantDao

    companion object {

        @Volatile
        private var INSTANCE: HarvestDatabase? = null

        fun getDatabase(context: Context): HarvestDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HarvestDatabase::class.java,
                    "harvest_db"
                )
                    .fallbackToDestructiveMigration() // ✅ dev-safe
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
