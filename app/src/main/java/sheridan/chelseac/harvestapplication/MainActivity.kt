package sheridan.chelseac.harvestapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import sheridan.chelseac.harvestapplication.data.local.HarvestDatabase
import sheridan.chelseac.harvestapplication.data.repository.HarvestRepository
import sheridan.chelseac.harvestapplication.ui.screens.HarvestScreen
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModelFactory
import sheridan.chelseac.harvestapplication.ui.theme.HarvestApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = HarvestDatabase.getDatabase(applicationContext)
        val repository = HarvestRepository(database.harvestDao())
        val viewModelFactory = HarvestViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, viewModelFactory)[HarvestViewModel::class.java]

        setContent {
            HarvestApplicationTheme {
                HarvestScreen(viewModel)
            }
        }
    }
}
