package uvg.edu.gt.rickandmorty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import uvg.edu.gt.rickandmorty.ui.theme.RickandMortyTheme

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://path-to-rick-and-morty-logo.png"),  // Logo de Rick & Morty
            contentDescription = "Rick & Morty Logo",
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate("characters")  // Navegar a la lista de personajes
        }) {
            Text("Entrar")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text("Pablo Méndez - 23975", color = Color.Gray, textAlign = TextAlign.Center)
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    RickandMortyTheme {
        LoginScreen(navController = rememberNavController())
    }
}