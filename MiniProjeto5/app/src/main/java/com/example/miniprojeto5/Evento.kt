package com.example.miniprojeto5

//Classe de dados para representar cada evento
data class Evento(
    val nomeDoEvento: String,
    val nomeDoResponsavel: String,
    val dataDoEvento: String,
    val descricaoDoEvento: String,
    val eventoConcluido: Boolean
)