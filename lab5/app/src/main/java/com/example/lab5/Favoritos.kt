package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.R
import com.example.lab5.ui.theme.Lab5Theme
import androidx.compose.ui.graphics.RectangleShape

// Define una clase para representar un favorito con atributos como título, ubicación e imagen.
data class Favorite(val title: String, val location: String, val imageResourceId: Int)

// Actividad que muestra los favoritos
class FavoritesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la actividad
        setContent {
            Lab5Theme {
                FavoritesContent()
            }
        }
    }
}

@Composable
fun FavoritesContent() {
    // Columna principal que ocupa todo el espacio disponible
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp), // Espaciado vertical entre los hijos
        horizontalAlignment = Alignment.CenterHorizontally // Alineación horizontal al centro
    ) {
        // Barra de título en la parte superior
        Row(
            modifier = Modifier.fillMaxWidth().background(Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Eventos Favoritos",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(30.dp)
            )
        }

        // Lista de favoritos
        Column(modifier = Modifier.padding(16.dp)) {
            // Datos de muestra para la lista de favoritos
            val favorites = listOf(
                Favorite("Concierto de Bad Bunny", "Cardales", R.drawable.bbbello),
                Favorite("Concierto de Billie Eilish", "Cardales", R.drawable.billiemiamor),
                Favorite("Concierto de C. Tangana", "Parque de la industria", R.drawable.ctangana),
                Favorite("Concierto de Labrynth", "Majadas", R.drawable.labrinth)
            )

            // Itera sobre cada favorito y crea una tarjeta para él
            favorites.forEach { favorite ->
                FavoriteCard(favorite)
            }
        }
    }
}

// Tarjeta de favorito individual
@Composable
fun FavoriteCard(favorite: Favorite) {
    // Tarjeta con sombra y forma rectangular
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(135.dp) // Altura fija
            .padding(8.dp), // Espacio externo
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RectangleShape // Esquinas cuadradas
    ) {
        // Contenido de la tarjeta
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically // Alineación vertical al centro
        ) {
            // Muestra la imagen del favorito
            Image(
                painter = painterResource(id = favorite.imageResourceId),
                contentDescription = "Event Image",
                modifier = Modifier.size(100.dp) // Tamaño fijo de la imagen
            )
            Spacer(modifier = Modifier.width(16.dp)) // Espacio entre la imagen y el texto
            Column {
                // Título del favorito
                Text(
                    text = favorite.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp)) // Espacio entre el título y la ubicación
                // Ubicación del favorito
                Text(
                    text = favorite.location,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
            Spacer(modifier = Modifier.weight(1f)) // Espacio flexible al final de la fila
        }
    }
}
