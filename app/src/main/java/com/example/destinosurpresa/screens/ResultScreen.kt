package com.example.destinosurpresa.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.destinosurpresa.viewmodel.MainViewModel

@Composable
fun ResultScreen(tipo: String, navController: NavController, viewModel: MainViewModel) {
    val destino by remember { mutableStateOf(viewModel.gerarDestino(tipo)) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF0D47A1), 	Color(0xFFCFD8DC))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = destino.nome,
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFFF2F2F2)
            )

            Spacer(modifier = Modifier.height(16.dp))

            AsyncImage(
                model = destino.imagemUrl,
                contentDescription = destino.nome,
                modifier = Modifier
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(2.dp, Color.White, RoundedCornerShape(12.dp))
                    .shadow(4.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF37474F)) // cinza azulado
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Curiosidade Histórica",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color(0xFFFFF59D) // amarelo suave
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = destino.curiosidadeHistorica,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                }
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0D47A1))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Mensagem do Destino",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color(0xFFFFF59D) // amarelo suave
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = destino.frase,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Medium
                        ),
                        color = Color.White
                    )
                }
            }



            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0D47A1),
                    contentColor = Color.White
                ),

                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(top = 32.dp)

            ) {

                Text("Voltar")
            }

        }
    }
}