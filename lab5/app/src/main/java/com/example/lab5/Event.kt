package com.example.lab5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Define una clase para representar un evento con atributos como título, imagen, descripción, fecha y hora.
data class Event(val title: String, val imageRes: Int, val description: String, val fecha: String, val hora: String)

@Composable
fun InfoConciertosScreen(events: List<Event>, navController: NavController) {
    // Contenedor principal que se ajusta al tamaño máximo disponible
    Box(modifier = Modifier.fillMaxSize()) {
        // Columna con capacidad de desplazamiento vertical
        Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            // Barra superior de la aplicación
            Row(
                modifier = Modifier.fillMaxWidth().background(Color.Black),
                horizontalArrangement = Arrangement.SpaceBetween // Organizar los elementos con espacio entre ellos
            ) {
                // Título de la aplicación
                Text(
                    "EventosMax+",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )
                // Botón con tres puntos verticales, para futuras opciones
                IconButton(onClick = { /* acción para los tres puntitos */ }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "Más opciones", tint = Color.White)
                }
            }
            // Espacio entre la barra superior y los eventos
            Spacer(modifier = Modifier.height(16.dp))
            // Lista de eventos en una cuadrícula de 2xN
            Column(modifier = Modifier.padding(16.dp)) {
                for (index in events.indices step 2) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Mostrar el evento de la izquierda
                        EventItem(event = events[index], navController = navController)
                        // Si hay un evento de la derecha, mostrarlo. De lo contrario, mostrar espacio vacío.
                        if (index + 1 < events.size) {
                            EventItem(event = events[index+1], navController = navController)
                        } else {
                            Box(modifier = Modifier.weight(1f))
                        }
                    }
                    // Espacio entre las filas de eventos
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

// Componente individual para mostrar un evento
@Composable
fun EventItem(event: Event, navController: NavController) {
    // Contenedor de evento que puede ser tocado
    Column(
        modifier = Modifier
            .width(160.dp)  // Ancho fijo
            .clickable {navController.navigate("detalle/${event.title}/${event.fecha}/${event.hora}/${event.description}/${event.imageRes}")}
            .padding(8.dp)
            .background(color = Color.LightGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente
    ) {
        // Muestra la imagen del evento
        Image(
            painter = painterResource(id = event.imageRes),
            contentDescription = null,
            modifier = Modifier.size(64.dp).align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Título del evento
        Text(
            event.title,
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        // Descripción del evento
        Text(
            event.description,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}













