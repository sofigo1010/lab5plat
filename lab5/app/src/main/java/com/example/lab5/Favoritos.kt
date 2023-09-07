package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.R
import com.example.lab5.ui.theme.Lab5Theme
import androidx.compose.ui.graphics.RectangleShape

data class Favorite(val title: String, val location: String, val imageResourceId: Int)

class FavoritesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5Theme {
                FavoritesContent()
            }
        }
    }
}

@Composable
fun FavoritesContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp), // Reducir el espaciado
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tus eventos favoritos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        val favorites = listOf(
            Favorite("Concierto de Bad Bunny", "Cardales", R.drawable.bbbello),
            Favorite("Concierto de Humbe", "Cardales", R.drawable.bbbello),
            Favorite("Concierto de EDM", "Parque de la industria", R.drawable.bbbello),
            Favorite("Concierto de Wos", "Majadas", R.drawable.bbbello)
        )

        favorites.forEach { favorite ->
            FavoriteCard(favorite)
        }
    }
}

@Composable
fun FavoriteCard(favorite: Favorite) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(135.dp) // Altura fija para hacer las tarjetas rectangulares
            .padding(8.dp), // Añadir espacio interno
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RectangleShape // Hacer esquinas cuadradas
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = favorite.imageResourceId),
                contentDescription = "Event Image",
                modifier = Modifier
                    .size(100.dp) // Tamaño de la imagen
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = favorite.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = favorite.location,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}