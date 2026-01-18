package sheridan.chelseac.harvestapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import sheridan.chelseac.harvestapplication.ui.navigation.AppNavGraph
import sheridan.chelseac.harvestapplication.ui.theme.HarvestApplicationTheme
import sheridan.chelseac.harvestapplication.ui.viewmodel.HarvestViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HarvestApplicationTheme {

                val harvestViewModel: HarvestViewModel = viewModel()

                AppNavGraph(
                    viewModel = harvestViewModel
                )
            }
        }
    }
}
