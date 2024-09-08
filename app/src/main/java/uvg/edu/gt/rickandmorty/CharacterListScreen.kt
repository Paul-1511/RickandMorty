package uvg.edu.gt.rickandmorty


//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import uvg.edu.gt.rickandmorty.ui.theme.RickandMortyTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterListScreen(navController: NavController) {
    val characters = CharacterDb().getAllCharacters()  // Obtenemos los personajes de la base de datos

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Characters") }, backgroundColor = MaterialTheme.colors.primary)
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            characters.forEach { character ->
                CharacterRow(character = character, onClick = {
                    navController.navigate("characterDetail/${character.id}")
                })
            }
        }
    }
}

@Composable
fun CharacterRow(character: Character, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(character.image),  // Cargamos la imagen con Coil
            contentDescription = character.name,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.primary)  // Imagen circular
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(character.name, style = MaterialTheme.typography.h6)
            Text("${character.species} - ${character.status}", style = MaterialTheme.typography.body2)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewCharacterListScreen() {
    RickandMortyTheme {
        CharacterListScreen(navController = rememberNavController())
    }
}