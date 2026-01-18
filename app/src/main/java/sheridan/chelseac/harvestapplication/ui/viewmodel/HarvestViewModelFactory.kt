package sheridan.chelseac.harvestapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sheridan.chelseac.harvestapplication.data.local.dao.HarvestDao

class HarvestViewModelFactory(
    private val dao: HarvestDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HarvestViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HarvestViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
