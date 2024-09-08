package uvg.edu.gt.rickandmorty


//noinspection UsingMaterialAndMaterial3Libraries
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import uvg.edu.gt.rickandmorty.ui.theme.RickandMortyTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterDetailScreen(characterId: Int) {
    val character = CharacterDb().getCharacterById(characterId)  // Obtenemos el personaje por su ID

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Character Details") },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    IconButton(onClick = { /* Acción de volver */ }) {
                        Icon(painterResource(id = android.R.drawable.ic_menu_close_clear_cancel), contentDescription = null)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = character.name,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Name: ${character.name}", style = MaterialTheme.typography.h6)
            Text("Species: ${character.species}")
            Text("Status: ${character.status}")
            Text("Gender: ${character.gender}")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewCharacterDetailScreen() {
    // Crear un personaje de ejemplo para previsualización
    val sampleCharacter = Character(
        id = 2,
        name = "Morty Smith",
        status = "Alive",
        species = "Human",
        gender = "Male",
        image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
    )

    RickandMortyTheme {
        CharacterDetailScreen(characterId = sampleCharacter.id)
    }
}

