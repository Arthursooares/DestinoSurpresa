package com.example.destinosurpresa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.*
import com.example.destinosurpresa.screens.LoadingScreen
import com.example.destinosurpresa.ui.theme.DestinoSurpresaTheme
import com.example.destinosurpresa.ui.screens.HomeScreen
import com.example.destinosurpresa.ui.screens.ResultScreen
import com.example.destinosurpresa.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DestinoSurpresaTheme {
                val navController = rememberNavController()
                val viewModel: MainViewModel by viewModels()

                NavHost(navController = navController, startDestination = "loading/home") {
                    composable("loading/{destino}") { backStackEntry ->
                        val destino = backStackEntry.arguments?.getString("destino") ?: "home"
                        LoadingScreen(navController = navController, destinoFinal = destino)
                    }

                    composable("home") {
                        HomeScreen(navController)
                    }

                    composable("result/{tipo}") { backStackEntry ->
                        val tipo = backStackEntry.arguments?.getString("tipo") ?: "Aventura"
                        ResultScreen(
                            tipo = tipo,
                            navController = navController,
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}
