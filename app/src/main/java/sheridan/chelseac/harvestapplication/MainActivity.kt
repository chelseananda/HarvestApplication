package sheridan.chelseac.harvestapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import sheridan.chelseac.harvestapplication.data.local.database.HarvestDatabase
import sheridan.chelseac.harvestapplication.ui.screens.HarvestListScreen
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = HarvestDatabase.getDatabase(this).harvestDao()
        val factory = HarvestViewModelFactory(dao)

        setContent {
            val viewModel: HarvestViewModel = viewModel(factory = factory)
            HarvestListScreen(viewModel)
        }
    }
}
