package com.example.destinosurpresa.model

data class Destino(
    val nome: String,
    val curiosidade: String,
    val curiosidadeHistorica: String,
    val frase: String,
    val imagemUrl: String,
    val id: Int = nome.hashCode()
)
