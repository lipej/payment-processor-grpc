package dev.lipejose.domain.entities

data class Card(
    val number: String,
    var ccv: String,
    val exp: String,
    val name: String,
    val brand: String
)