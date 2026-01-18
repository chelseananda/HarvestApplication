package sheridan.chelseac.harvestapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import sheridan.chelseac.harvestapplication.data.local.HarvestDatabase
import sheridan.chelseac.harvestapplication.ui.navigation.AppNavGraph
import sheridan.chelseac.harvestapplication.ui.theme.HarvestApplicationTheme
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create database & DAO ONCE
        val database = HarvestDatabase.getDatabase(applicationContext)
        val dao = database.harvestDao()

        setContent {
            HarvestApplicationTheme {

                // Provide ViewModelFactory
                val harvestViewModel: HarvestViewModel = viewModel(
                    factory = HarvestViewModelFactory(dao)
                )

                AppNavGraph(
                    viewModel = harvestViewModel
                )
            }
        }
    }
}
