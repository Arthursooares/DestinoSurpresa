package com.example.destinosurpresa.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(onTipoSelecionado: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Destino Surpresa", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { onTipoSelecionado("aventura") }, modifier = Modifier.fillMaxWidth()) {
            Text("🧗‍♂️ Aventura")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onTipoSelecionado("relaxamento") }, modifier = Modifier.fillMaxWidth()) {
            Text("🧘 Relaxamento")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onTipoSelecionado("cultura") }, modifier = Modifier.fillMaxWidth()) {
            Text("🏛️ Cultura")
        }
    }
}
