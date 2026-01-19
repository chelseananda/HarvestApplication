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
import sheridan.chelseac.harvestapplication.ui.navigation.NavRoutes
import sheridan.chelseac.harvestapplication.ui.viewmodel.PlantViewModel

@Composable
fun PlantScreen(
    padding: PaddingValues,
    navController: NavController,
    viewModel: PlantViewModel
) {
    val plants = viewModel.getPlants()

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Plants",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
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
