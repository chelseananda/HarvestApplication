package sheridan.chelseac.harvestapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import sheridan.chelseac.harvestapplication.ui.navigation.AppNav
import sheridan.chelseac.harvestapplication.ui.theme.HarvestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarvestTheme {
                AppNav()
            }
        }
    }
}
