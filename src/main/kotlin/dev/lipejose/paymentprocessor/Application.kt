package dev.lipejose.paymentprocessor

import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("dev.lipejose.paymentprocessor")
        .start()
}

