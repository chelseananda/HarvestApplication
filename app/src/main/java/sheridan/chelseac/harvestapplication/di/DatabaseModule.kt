package sheridan.chelseac.harvestapplication.di

import android.content.Context
import sheridan.chelseac.harvestapplication.data.local.HarvestDatabase
import sheridan.chelseac.harvestapplication.data.repository.HarvestRepository

object DatabaseModule {

    // Single database instance
    fun provideDatabase(context: Context): HarvestDatabase {
        return HarvestDatabase.getInstance(context)
    }

    // Repository depends on DAO
    fun provideRepository(database: HarvestDatabase): HarvestRepository {
        return HarvestRepository(database.harvestDao())
    }
}
