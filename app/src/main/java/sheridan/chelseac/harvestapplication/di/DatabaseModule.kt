package sheridan.chelseac.harvestapplication.di

import android.content.Context
import sheridan.chelseac.harvestapplication.data.local.entity.HarvestDatabase
import sheridan.chelseac.harvestapplication.data.repository.GardenEventRepository
import sheridan.chelseac.harvestapplication.data.repository.GardenRepository
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

    fun provideGardenRepository(database: HarvestDatabase): GardenRepository {
        return GardenRepository(database.gardenDao())
    }

    fun provideGardenEventRepository(
        database: HarvestDatabase
    ): GardenEventRepository {
        return GardenEventRepository(database.gardenEventDao())
    }

}
