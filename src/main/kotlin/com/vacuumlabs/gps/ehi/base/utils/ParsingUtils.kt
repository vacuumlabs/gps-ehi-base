package com.vacuumlabs.gps.ehi.base.utils

import com.vacuumlabs.gps.ehi.base.Constants.ERROR_NOT_A_CURRENCY_CODE
import com.vacuumlabs.gps.ehi.base.Constants.ERROR_NOT_A_DATE
import com.vacuumlabs.gps.ehi.base.Constants.ERROR_NOT_A_NUMBER
import com.vacuumlabs.gps.ehi.base.Constants.dateFormatter
import org.springframework.validation.Errors
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.format.DateTimeParseException
import javax.money.CurrencyQueryBuilder
import javax.money.CurrencyUnit
import javax.money.Monetary
import javax.money.MonetaryException
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

fun <R, T : Throwable> withMessageForExceptions(message: String, vararg cls: KClass<out T>, block: () -> R): R {
    return try {
        block()
    } catch (e: Throwable) {
        if (cls.any { e::class.isSubclassOf(it) }) {
            throw IllegalArgumentException(message)
        }
        throw e
    }
}

val String.int: Int
    get() = withMessageForExceptions(ERROR_NOT_A_NUMBER, NumberFormatException::class) { toInt() }

val String.bigDecimal: BigDecimal
    get() = withMessageForExceptions(ERROR_NOT_A_NUMBER, NumberFormatException::class, ArithmeticException::class) { toBigDecimal() }

val String.date: LocalDateTime
    get() = withMessageForExceptions(ERROR_NOT_A_DATE, DateTimeParseException::class) { LocalDateTime.parse(this, dateFormatter) }

val String.currency: CurrencyUnit
    get() = withMessageForExceptions(ERROR_NOT_A_CURRENCY_CODE, MonetaryException::class) {
        val query = CurrencyQueryBuilder.of().setNumericCodes(int).build()
        Monetary.getCurrency(query)
    }

class InvalidInputException(val errors: Errors): RuntimeException(
    "Invalid input: \n" + errors.allErrors.joinToString(separator = "\n") { "$it" }
)