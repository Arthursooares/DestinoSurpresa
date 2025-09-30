package com.example.destinosurpresa.data

import com.example.destinosurpresa.model.Destino

fun sortearDestino(tipo: String): Destino {
    return when (tipo) {
        "Aventura" -> destinosAventura.random()
        "Relaxamento" -> destinosRelaxamento.random()
        "Cultura" -> destinosCultura.random()
        else -> Destino(
            nome = "Desconhecido",
            curiosidade = "Tipo inválido",
            curiosidadeHistorica = "Não há curiosidade histórica disponível.",
            frase = "Ops!",
            imagemUrl = ""
        )

    }
}
