package sheridan.chelseac.harvestapplication.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sheridan.chelseac.harvestapplication.di.DatabaseModule

class GardenViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GardenViewModel::class.java)) {
            val database = DatabaseModule.provideDatabase(context)
            val repository = DatabaseModule.provideGardenRepository(database)
            return GardenViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
