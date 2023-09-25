package com.example.lab5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.ui.graphics.Color



// Clase para representar un concierto con atributos como título, imagen, descripción e imagen derecha.
data class Concierto(val title: String, val imageRes: Int, val description: String, val imageRightRes: Int)

@Composable
fun InfoConciertos(events: List<Concierto>) {
    // Contenedor principal que ocupa todo el espacio disponible
    Box(modifier = Modifier.fillMaxSize()) {
        // Columna perezosa que permite desplazarse y se usa para mostrar la lista de conciertos
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            // Itera sobre cada concierto y muestra su información
            items(events) { concierto ->
                Event(concierto = concierto)
                Spacer(modifier = Modifier.height(8.dp))  // Espaciado entre elementos
                Divider(color = Color.Gray, thickness = 0.5.dp)  // Línea divisoria entre elementos
            }
        }
    }
}

@Composable
fun Event(concierto: Concierto) {
    // Contenedor en fila para mostrar la información de un concierto
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,  // Distribución de espacio entre hijos
        verticalAlignment = Alignment.CenterVertically     // Alineación vertical al centro
    ) {
        // Imagen del concierto a la izquierda
        Image(
            painter = painterResource(id = concierto.imageRes),
            contentDescription = null,  // No es necesario describir el contenido
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)       // Dar forma circular a la imagen
                .padding(8.dp),
            contentScale = ContentScale.Crop  // Escalar el contenido para recortar
        )

        // Columna para mostrar el título y la descripción del concierto
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = concierto.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,              // Limitar a 2 líneas
                overflow = TextOverflow.Ellipsis  // Puntos suspensivos si el texto es largo
            )
            Text(
                text = concierto.description,
                fontSize = 16.sp,
                maxLines = 3,              // Limitar a 3 líneas
                overflow = TextOverflow.Ellipsis  // Puntos suspensivos si el texto es largo
            )
        }

        // Imagen del concierto a la derecha
        Image(
            painter = painterResource(id = concierto.imageRightRes),
            contentDescription = null,  // No es necesario describir el contenido
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)       // Dar forma circular a la imagen
                .padding(8.dp),
            contentScale = ContentScale.Crop  // Escalar el contenido para recortar
        )
    }
}


