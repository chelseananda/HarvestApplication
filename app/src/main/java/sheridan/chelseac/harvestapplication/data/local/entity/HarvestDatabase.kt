package sheridan.chelseac.harvestapplication.data.local.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sheridan.chelseac.harvestapplication.data.local.dao.HarvestDao

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
                Room.databaseBuilder(
                    context.applicationContext,
                    HarvestDatabase::class.java,
                    "harvest_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}