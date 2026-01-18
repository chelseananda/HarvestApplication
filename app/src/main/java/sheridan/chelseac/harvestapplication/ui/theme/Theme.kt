package sheridan.chelseac.harvestapplication.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = DarkGreen,
    secondary = LightGreen,
    background = SageGreen,
    surface = SageGreen,
    onPrimary = Color.White,
    onBackground = TextDark,
    onSurface = TextDark

)

@Composable
fun HarvestApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography(),
        content = content
    )
}
