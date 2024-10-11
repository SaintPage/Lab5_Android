package com.example.lab5angemerida

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.lab5angemerida.ui.theme.Celeste
import com.example.lab5angemerida.ui.theme.Lab5AngeMeridaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5AngeMeridaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Contenido principal de la actividad
                    MainActivityContent()
                }
            }
        }
    }
}

@Composable
fun MainActivityContent() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        CelesteButton(
            text = "Ir a Información de Conciertos",
            onClick = {
                val intent = Intent(context, ConcertInfoActivity::class.java)
                context.startActivity(intent)
            }
        )
        CelesteButton(
            text = "Ir a Lista de Lugares",
            onClick = {
                val intent = Intent(context, PlacesListActivity::class.java)
                context.startActivity(intent)
            }
        )
        CelesteButton(
            text = "Ir a Detalles del Evento",
            onClick = {
                val intent = Intent(context, EventDetailActivity::class.java)
                context.startActivity(intent)
            }
        )
        CelesteButton(
            text = "Ir a Perfil",
            onClick = {
                val intent = Intent(context, ProfileActivity::class.java)
                context.startActivity(intent)
            }
        )
    }
}

@Composable
fun CelesteButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Celeste,
            contentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = text)
    }
}
