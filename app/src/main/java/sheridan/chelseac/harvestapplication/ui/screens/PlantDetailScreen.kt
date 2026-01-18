package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlantDetailScreen(
    padding: PaddingValues
) {
    val tomato = PlantDetail(
        name = "Tomato",
        category = "Vegetable",
        sunlight = "Full Sun (6–8 hrs)",
        water = "2 inches / week",
        temperature = "18–29°C",
        description = "Tomatoes grow best in warm weather and full sunlight. They are easy to grow and perfect for home gardens."
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(Color(0xFFF3F6F2))
            .padding(16.dp)
    ) {

        // Title
        Text(
            text = tomato.name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2F5D2E)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Category Tag
        Surface(
            color = Color(0xFF9ACD32),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = tomato.category,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Info Cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoCard(title = "Sunlight", value = tomato.sunlight)
            InfoCard(title = "Water", value = tomato.water)
            InfoCard(title = "Temp", value = tomato.temperature)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Description
        Text(
            text = "Description",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = tomato.description,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        // Add Button
        Button(
            onClick = {
                // later: add plant to selected garden
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF9ACD32)
            ),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                text = "Add to Garden",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}
