package com.example.lab5
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Se importa la anotación Experimental para el uso de características experimentales en Compose.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginActivity(navController: NavController) {
    // Estos son estados para almacenar el email y la contraseña ingresados por el usuario.
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Se define la estructura de la pantalla de inicio de sesión.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Texto del título.
        Text(
            text = "Iniciar sesión",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Campo para ingresar el email/usuario.
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Usuario") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Campo para ingresar la contraseña.
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Acciones a realizar cuando el usuario presiona "Done" en el teclado.
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Botón de inicio de sesión.
        Button(
            onClick = {
                // Lógica para validar y navegar si el inicio de sesión es correcto.
                navController.navigate(Screen.EventosMax.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Iniciar sesión")
        }
    }
}

// Representación de las distintas pantallas/rutas de la aplicación.
sealed class Screen(val route: String) {
    object Login : Screen("login")
    object EventosMax : Screen("EventosMax+")
}

@Composable
fun NavigationHost(events: List<Event>, concerts: List<Concierto>) {
    // Controlador de navegación de Compose para gestionar las transiciones entre pantallas.
    val navController = rememberNavController()

    // Definición de las rutas y sus respectivas pantallas.
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginActivity(navController = navController)
        }
        composable(Screen.EventosMax.route) {
            TodoEventoApp(events = events, concerts = concerts, navController)
        }
        composable("detalle/{title}/{fecha}/{hora}/{description}/{imageRes}") { backStackEntry ->
            // Extracción de argumentos pasados en la ruta.
            val titulo = backStackEntry.arguments?.getString("title") ?: ""
            val fecha = backStackEntry.arguments?.getString("fecha") ?: ""
            val hora = backStackEntry.arguments?.getString("hora") ?: ""
            val descripcion = backStackEntry.arguments?.getString("description") ?: ""
            val fotica = backStackEntry.arguments?.getString("imageRes")?.toIntOrNull() ?: 0

            // Llamada a la función composable que muestra el detalle.
            DetalleComposable(titulo, fecha, hora, descripcion, fotica, navController)
        }
    }
}







