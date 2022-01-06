package com.vacuumlabs.gps.ehi.base

import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

object Constants {
    const val NAMESPACE_URI: String = "http://tempuri.org/"

    val dateFormatter: DateTimeFormatter = DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .append(DateTimeFormatter.ISO_LOCAL_DATE)
        .appendLiteral(' ')
        .append(DateTimeFormatter.ISO_LOCAL_TIME)
        .toFormatter()

    const val ERROR_MISSING_REQUIRED_VALUE = "Missing required value"
    const val ERROR_NOT_A_NUMBER = "Not a number"
    const val ERROR_NOT_A_DATE = "Not a date"
    const val ERROR_NOT_A_CURRENCY_CODE = "Not a currency code"

    const val ACKNOWLEDGEMENT_OK = "1"
    const val ACKNOWLEDGEMENT_NOT_OK = "0"

    enum class ResponseStatus(val statusCode: String) {
        ACCEPTED("00"),
        REJECTED("05")
    }
}