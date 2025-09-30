package com.example.destinosurpresa.viewmodel

import androidx.lifecycle.ViewModel
import com.example.destinosurpresa.model.Destino
import com.example.destinosurpresa.data.sortearDestino

class MainViewModel : ViewModel() {
    fun gerarDestino(tipo: String): Destino {
        return sortearDestino(tipo)
    }
}
