package dev.lipejose.domain.services

import dev.lipejose.PaymentRequest
import dev.lipejose.PaymentResponse
import dev.lipejose.domain.entities.Card
import dev.lipejose.domain.entities.Customer
import dev.lipejose.domain.entities.Order
import dev.lipejose.domain.services.protocols.PaymentProvider

class PaymentService(private val provider: PaymentProvider) {
    fun process(request: PaymentRequest): PaymentResponse {
        val card = Card(request.card.number, request.card.ccv, request.card.exp, request.card.name, request.card.brand)
        val customer =  Customer(request.order.customer.firstName, request.order.customer.lastName)
        val order = Order(request.order.orderId, request.order.amount, customer)
        println(order)
        println(card)
        println(customer)

        return provider.execute(card, order)
    }
}