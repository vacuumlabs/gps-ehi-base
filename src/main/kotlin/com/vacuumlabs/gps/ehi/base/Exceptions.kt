package com.vacuumlabs.gps.ehi.base

open class CardProcessingException(
    message: String,
    cause: Throwable? = null
) : RuntimeException(message, cause)

class UnexpectedCardEventException(
    message: String,
) : CardProcessingException(message)

class UnsupportedCardEventException(message: String) : CardProcessingException(message)
