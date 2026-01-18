package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PlantScreen(
    padding: PaddingValues,
    navController: NavController
) {

    val plants = listOf(
        Plant("Tomato", "Sunny", "60–100 days", "2 in/week"),
        Plant("Carrot", "Partial Sun", "70 days", "1 in/week")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        plants.forEach { plant ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                onClick = {
                    navController.navigate("plantDetail")
                }
            ) {
                PlantCard(plant)
            }
        }
    }
}
