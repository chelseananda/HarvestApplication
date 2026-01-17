package sheridan.chelseac.harvestapplication.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sheridan.chelseac.harvestapplication.data.local.HarvestDatabase
import sheridan.chelseac.harvestapplication.data.repository.HarvestRepository

class HarvestViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val database = HarvestDatabase.getInstance(context)
        val repository = HarvestRepository(database.harvestDao())

        return HarvestViewModel(repository) as T
    }
}
