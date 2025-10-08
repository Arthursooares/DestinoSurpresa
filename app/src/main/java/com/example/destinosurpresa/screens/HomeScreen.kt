package com.example.destinosurpresa.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.destinosurpresa.R
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage


@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF0D47A1), 	Color(0xFFCFD8DC)

                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
            .offset(y = (-32).dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 32.dp)
                    .widthIn(max = 400.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Destino Surpresa",
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Divider(
                        modifier = Modifier
                            .width(220.dp)
                            .height(2.dp),
                        color = Color.White
                    )
                }



                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Escolha o tipo de viagem",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(32.dp))

                TipoViagemBotao(
                    tipo = "Aventura",
                    emoji = "🧗",
                    corFundo = Color(0xFF1565C0),
                    onClick = { navController.navigate("result/Aventura") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                TipoViagemBotao(
                    tipo = "Relaxamento",
                    emoji = "🧘",
                    corFundo = Color(0xFF1565C0),
                    onClick = { navController.navigate("result/Relaxamento") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                TipoViagemBotao(
                    tipo = "Cultura",
                    emoji = "🏛️",
                    corFundo = Color(0xFF1565C0),
                    onClick = { navController.navigate("result/Cultura") }
                )

                Spacer(modifier = Modifier.height(24.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0D47A1))
                ) {
                    Text(
                        text = "🌍 Destaque: Viagens únicas e inesquecíveis",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White
                    )
                }
            }
        }
    }
}


@Composable
fun TipoViagemBotao(
    tipo: String,
    emoji: String,
    corFundo: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = corFundo,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, Color(0xFF0D47A1))
    ) {
        Text(
            text = "$emoji $tipo", // ← aqui junta emoji + texto
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
    }
}



