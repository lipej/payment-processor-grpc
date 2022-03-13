package dev.lipejose.paymentprocessor.domain.entities

class Order(
    val id: String,
    val amount: Int,
    val customer: Customer
)

