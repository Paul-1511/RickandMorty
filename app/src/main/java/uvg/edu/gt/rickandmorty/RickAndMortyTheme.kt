package uvg.edu.gt.rickandmorty

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import uvg.edu.gt.rickandmorty.ui.theme.Teal200
import uvg.edu.gt.rickandmorty.ui.theme.Teal700
import uvg.edu.gt.rickandmorty.ui.theme.Purple500
import uvg.edu.gt.rickandmorty.ui.theme.Typography
import uvg.edu.gt.rickandmorty.ui.theme.Shapes

@Composable
fun RickAndMortyTheme(content: @Composable () -> Unit) {
    val colors = lightColorScheme(
        primary = Teal200,
        primaryContainer = Teal700,
        secondary = Purple500
    )

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
