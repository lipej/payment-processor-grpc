package dev.lipejose.presentation.endpoints

import dev.lipejose.PaymentServiceGrpcKt
import dev.lipejose.PaymentRequest
import dev.lipejose.PaymentResponse
import dev.lipejose.domain.error.ProviderNotImplementedError
import dev.lipejose.domain.services.PaymentService
import dev.lipejose.domain.services.protocols.PaymentProvider
import dev.lipejose.main.factories.ProvidersFactory
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

@Singleton
class PaymentEndpoint : PaymentServiceGrpcKt.PaymentServiceCoroutineImplBase() {

    override suspend fun process(request: PaymentRequest): PaymentResponse {
        return when (val worker = ProvidersFactory().create(request.provider)) {
            is PaymentProvider -> PaymentService(worker).process(request)
            else -> ProviderNotImplementedError(request.provider).build()
        }
    }

    override fun processStream(requests: Flow<PaymentRequest>): Flow<PaymentResponse> = flow {
        requests.collect {
            emit(
                when (val worker = ProvidersFactory().create(it.provider)) {
                    is PaymentProvider -> PaymentService(worker).process(it)
                    else -> ProviderNotImplementedError(it.provider).build()
                }
            )
        }
    }
}