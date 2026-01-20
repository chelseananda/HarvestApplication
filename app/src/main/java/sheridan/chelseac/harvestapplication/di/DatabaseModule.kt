package sheridan.chelseac.harvestapplication.di

import android.content.Context
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestDatabase
import sheridan.chelseac.harvestapplication.data.repository.HarvestRepository

object DatabaseModule {

    // Single database instance
    fun provideDatabase(context: Context): HarvestDatabase {
        return HarvestDatabase.getDatabase(context)
    }

    // Repository depends on DAO
    fun provideRepository(database: HarvestDatabase): HarvestRepository {
        return HarvestRepository(database.harvestDao())
    }
}
