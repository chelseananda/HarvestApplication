package sheridan.chelseac.harvestapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GardenScreen(
    padding: PaddingValues
) {
    // State to control dialog visibility
    var showAddGardenDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(Color(0xFFC9DCC7)) // soft green (Figma-like)
    ) {

        //Screen Title
        Text(
            text = "Gardens",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2F5D2E),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 24.dp)
        )

        // Empty State Text
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "you don’t have any garden.",
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Want to add some?",
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        //NEW GARDEN Button
        Button(
            onClick = {
                showAddGardenDialog = true
            },
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF9ACD32)
            ),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
        ) {
            Text(
                text = "+  NEW GARDEN",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }

    //Add Garden Dialog
    if (showAddGardenDialog) {
        AddGardenDialog(
            onDismiss = { showAddGardenDialog = false },
            onSave = { gardenName ->
                // TODO (next step): save garden to ViewModel / DB
                showAddGardenDialog = false
            }
        )
    }
}
