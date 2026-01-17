package sheridan.chelseac.harvestapplication.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import sheridan.chelseac.harvestapplication.data.local.AppDatabase
import sheridan.chelseac.harvestapplication.data.local.PlantDao
import javax.inject.Singleton

/**
 * Hilt module to provide database-related dependencies.
 * Graduate Level Concept: Dependency Inversion. 
 * By providing the DAO via Hilt, we make our ViewModels and Repositories testable.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "botanist_database"
        ).fallbackToDestructiveMigration() // Useful during development for university projects
         .build()
    }

    @Provides
    fun providePlantDao(appDatabase: AppDatabase): PlantDao {
        return appDatabase.plantDao()
    }
}
