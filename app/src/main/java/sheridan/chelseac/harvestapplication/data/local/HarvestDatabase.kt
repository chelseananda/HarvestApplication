package sheridan.chelseac.harvestapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sheridan.chelseac.harvestapplication.data.local.dao.HarvestDao
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestEntity

/**
 * Main Room database
 */
@Database(
    entities = [HarvestEntity::class],
    version = 1,
    exportSchema = false
)
abstract class HarvestDatabase : RoomDatabase() {

    abstract fun harvestDao(): HarvestDao

    companion object {
        @Volatile
        private var INSTANCE: HarvestDatabase? = null

        fun getDatabase(context: Context): HarvestDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HarvestDatabase::class.java,
                    "harvest_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}
