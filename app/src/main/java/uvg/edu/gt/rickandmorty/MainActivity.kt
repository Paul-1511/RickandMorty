package uvg.edu.gt.rickandmorty

//noinspection UsingMaterialAndMaterial3Libraries
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uvg.edu.gt.rickandmorty.ui.theme.RickandMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyApp()
        }
    }
}

@Composable
fun RickAndMortyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("characters") { CharacterListScreen(navController) }
        composable("characterDetail/{characterId}") { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")
            CharacterDetailScreen(characterId?.toInt() ?: 0)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewRickAndMortyApp() {
    RickandMortyTheme {
        RickAndMortyApp()
    }
}