package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import sheridan.chelseac.harvestapplication.ui.components.PlantCard
import sheridan.chelseac.harvestapplication.ui.model.Plant
import sheridan.chelseac.harvestapplication.ui.navigation.NavRoutes

@Composable
fun PlantScreen(
    padding: PaddingValues,
    navController: NavController
) {
    val plants = listOf(
        Plant(1, "Tomato", "Full Sun", "2 in/week", "60–100 days"),
        Plant(2, "Carrot", "Full Sun", "1 in/week", "70–80 days"),
        Plant(3, "Basil", "Partial Sun", "1.5 in/week", "30–40 days"),
        Plant(4, "Lettuce", "Partial Sun", "1 in/week", "45–55 days")
    )

    Column(
        modifier = Modifier
            .padding(padding)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Plants",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(plants) { plant ->
                PlantCard(
                    plant = plant,
                    onClick = {
                        navController.navigate(
                            "${NavRoutes.PLANT_DETAIL}/${plant.id}"
                        )
                    }
                )
            }
        }
    }
}
