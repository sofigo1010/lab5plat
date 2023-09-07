package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab5.ui.theme.Lab5Theme

class MainActivity : ComponentActivity() {
    // Datos de muestra
    val sampleEvents = listOf(
        Event("Billie Eilish", R.drawable.billiemiamor, "Happier Than Ever World Tour"),
        Event("Bad Bunny", R.drawable.bbbello, "Un Verano Sin Ti World Tour"),
        Event("C. Tangana", R.drawable.ctangana, "El Madrileño Presenta") ,
        Event("Miley Cyrus", R.drawable.mileybaby, "Endless Summer Now Available"),
        Event("SZA", R.drawable.szan, "Your ex better be hiding"),
        Event("Labrinth", R.drawable.labrinth, "Ready to feel the euphoria vibe?"),
    )

    val conciertos = listOf(
        Concierto("Billie Eilish", R.drawable.billiemiamor, "Ciudad Cayala", R.drawable.triangle),
        Concierto("Bad Bunny", R.drawable.bbbello, "Ciudad Cayala", R.drawable.triangle),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //InfoConciertosScreen(events = sampleEvents) //información de los conciertos que vienen.
                    //InfoConciertos(conciertos) // Listado de Lugares
                    //UserProfile() //perfil
                    DetalleComposable(titulo = "Un verano sin ti", fecha = "FECHA: 10/10", hora = "HORA: 7:30", descripcion = "Se realizará en Ciudad Cayala") //detalle del concierto
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab5Theme {
        Greeting("Android")
    }
}