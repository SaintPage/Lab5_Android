// EventDetailActivity.kt
package com.example.lab5angemerida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5angemerida.ui.theme.Celeste
import com.example.lab5angemerida.ui.theme.Lab5AngeMeridaTheme

class EventDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5AngeMeridaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EventDetailScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detalles del Evento") },
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                EventDetailContent()
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /* Acción para marcar como favorito */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Celeste,
                        contentColor = Color.White // Opcional: asegura que el texto sea legible
                    )
                ) {
                    Text(text = "Favorito")
                }
                Button(
                    onClick = { /* Acción para comprar */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Celeste,
                        contentColor = Color.White // Opcional
                    )
                ) {
                    Text(text = "Comprar")
                }
            }
        }
    )
}

@Composable
fun EventDetailContent() {
    val imageResource = R.drawable.evento // Asegúrate de que esta imagen existe en tus recursos

    Image(
        painter = painterResource(id = imageResource),
        contentDescription = "Imagen del Evento",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(bottom = 16.dp)
    )

    Text(
        text = "Título del Evento",
        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
    )

    Spacer(modifier = Modifier.height(8.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DateWithIcon()
        Text(text = "Hora", style = MaterialTheme.typography.bodyMedium)
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = "Acerca del Evento",
        style = MaterialTheme.typography.titleMedium.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = "Descripción detallada del evento.",
        style = MaterialTheme.typography.bodyMedium
    )

    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
fun DateWithIcon() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = "Ícono de Calendario"
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Fecha", style = MaterialTheme.typography.bodyMedium)
    }
}
