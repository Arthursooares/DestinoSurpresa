package com.example.destinosurpresa.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(navController: NavController) {
    // Estado para controlar o tempo de exibição
    LaunchedEffect(Unit) {
        delay(3000) // espera 3 segundos
        navController.navigate("home") {
            popUpTo("loading") { inclusive = true } // remove a tela de loading da pilha
        }
    }

    // UI da tela de carregamento
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Carregando destinos...",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
