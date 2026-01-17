package sheridan.chelseac.harvestapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import sheridan.chelseac.harvestapplication.di.DatabaseModule
import sheridan.chelseac.harvestapplication.ui.screens.HarvestScreen
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Manual Dependency Injection
        val database = DatabaseModule.provideDatabase(applicationContext)
        val repository = DatabaseModule.provideRepository(database)
        val viewModelFactory = HarvestViewModelFactory(repository)
        val viewModel = viewModelFactory.create(HarvestViewModel::class.java)

        setContent {
            HarvestScreen(viewModel = viewModel)
        }
    }
}
