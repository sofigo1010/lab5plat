package com.example.lab5


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun DetalleComposable(titulo: String, fecha: String, hora: String, descripcion: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Imagen en la parte superior
        Image(
            painter = painterResource(id = R.drawable.party),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        // Espacio entre la imagen y el texto
        Spacer(modifier = Modifier.height(16.dp))

        // Título
        Text(
            text = titulo,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 16.dp)
        )

        // Espacio entre el título y la fecha/hora
        Spacer(modifier = Modifier.height(8.dp))

        // Fecha y hora
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = fecha)
            Text(text = hora)
        }

        // Espacio entre la fecha/hora y la descripción
        Spacer(modifier = Modifier.height(8.dp))

        // Título de la descripción
        Text(
            text = "Descripción",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 16.dp)
        )

        // Espacio entre el título de la descripción y la descripción
        Spacer(modifier = Modifier.height(8.dp))

        // Descripción
        Text(
            text = descripcion,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
    }
}
