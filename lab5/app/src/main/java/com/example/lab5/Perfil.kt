package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.ui.theme.Lab5Theme

// Definición de la actividad "Perfil", que hereda de ComponentActivity, diseñada para trabajar con Jetpack Compose.
class Perfil: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Establece el contenido de la actividad.
        setContent {
            // Aplica el tema definido en Lab5Theme.
            Lab5Theme {
                // Crea una superficie con color blanco que ocupa todo el espacio disponible.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    // Agrega el perfil de usuario como contenido de esta superficie.
                    UserProfile()
                }
            }
        }
    }
}

// Modelo de datos para los elementos de la tarjeta que se mostrarán en el perfil.
data class CardItem(
    val title: String,
    val imageResourceId: Int,
    val hasToggleButton: Boolean,
)

// Función Composable para mostrar el perfil del usuario.
@Composable
fun UserProfile() {
    // Define una columna que ocupa todo el tamaño disponible y tiene un fondo blanco.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Caja que ocupa el 40% del alto disponible.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ) {
            // Muestra una imagen de fondo.
            Image(
                painter = painterResource(id = R.drawable.party),
                contentDescription = "Profile Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Columna centrada que muestra una imagen de perfil y el nombre de usuario.
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                // Imagen de perfil.
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                // Espaciador para separación.
                Spacer(modifier = Modifier.height(8.dp))
                // Texto con el nombre de usuario.
                Text(
                    text = "Nombre de Usuario",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
        // Espaciador para separación.
        Spacer(modifier = Modifier.height(20.dp))

        // Lista de elementos de tarjeta para el perfil.
        val cardItems = listOf(
            CardItem("Editar perfil", R.drawable.profile, false),
            CardItem("Reiniciar Contraseña", R.drawable.pass, false),
            CardItem("Notificaciones", R.drawable.notif, true),
            CardItem("Favoritos", R.drawable.fave, false)
        )

        // Itera sobre cada elemento de la tarjeta y lo muestra.
        cardItems.forEach { cardItem ->
            ProfileCardItemView(cardItem)
            // Espaciador entre elementos.
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

// Vista Composable para un botón de alternancia (toggle).
@Composable
fun ToggleButtonView() {
    Switch(
        checked = false, // Valor por defecto (no activado).
        onCheckedChange = {}, // Acción al cambiar estado (aquí no se define ninguna acción).
        modifier = Modifier.padding(4.dp)
    )
}

// Vista Composable para mostrar un elemento individual de la tarjeta en el perfil.
@Composable
fun ProfileCardItemView(cardItem: CardItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(0.dp) // Esquinas redondeadas (aquí se define 0, lo que significa esquinas cuadradas).
    ) {
        Row(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Muestra una imagen para el elemento de la tarjeta.
            Image(
                painter = painterResource(id = cardItem.imageResourceId),
                contentDescription = "Card Image",
                modifier = Modifier
                    .size(18.dp)
            )
            // Espaciador para separación.
            Spacer(modifier = Modifier.width(16.dp))

            // Texto para el título del elemento de la tarjeta.
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            ) {
                Text(
                    text = cardItem.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            // Dependiendo de si el elemento tiene un botón de alternancia o no, muestra el botón o una imagen.
            if (cardItem.hasToggleButton) {
                ToggleButtonView()
            } else {
                Image(
                    painter = painterResource(id = R.drawable.triangle),
                    contentDescription = "Small Image",
                    modifier = Modifier
                        .size(16.dp)
                )
            }
        }
    }
}

