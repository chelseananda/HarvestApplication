package sheridan.chelseac.harvestapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import sheridan.chelseac.harvestapplication.ui.navigation.AppNavGraph
import sheridan.chelseac.harvestapplication.ui.theme.HarvestApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HarvestApplicationTheme {
                AppNavGraph()
            }
        }
    }
}
