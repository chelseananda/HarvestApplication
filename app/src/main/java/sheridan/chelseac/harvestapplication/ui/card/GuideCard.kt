package sheridan.chelseac.harvestapplication.ui.card

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sheridan.chelseac.harvestapplication.ui.model.Guide

@Composable
fun GuideCard(guide: Guide) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = guide.title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = guide.subtitle,
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = guide.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
