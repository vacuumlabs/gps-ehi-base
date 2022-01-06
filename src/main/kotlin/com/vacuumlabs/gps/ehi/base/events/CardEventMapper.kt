package com.vacuumlabs.gps.ehi.base.events

import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table
import com.vacuumlabs.gps.ehi.base.UnsupportedCardEventException
import com.vacuumlabs.gps.ehi.base.soap.GetTransaction

enum class RequestType {
    AUTHORISATION_REQUEST,
    AUTOMATIC_AUTHORISATION_REVERSAL,
    AUTHORISATION_REPEAT,
    AUTHORISATION_ADVICE,
    AUTHORISATION_REVERSAL_FUEL_DISPENSER,
    AUTHORISATION_REVERSAL_REQUEST,
    AUTHORISATION_REVERSAL_ADVICE,
    AUTHORISATION_ADVICE_NOTIFICATION,
    FINANCIAL_REVERSAL,
    CHARGEBACK_NOTIFICATION,
    CHARGEBACK_NOTIFICATION_NON_CREDIT,
    CHARGEBACK_REVERSAL,
    FINANCIAL_NOTIFICATION_FIRST_PRESENTMENT,
    FINANCIAL_NOTIFICATION_SECOND_PRESENTMENT,
    FEE_NOTIFICATION
}

val table: Table<String, String, RequestType> = HashBasedTable.create<String, String, RequestType>().also { table ->
    table.put("0100", "A", RequestType.AUTHORISATION_REQUEST)
    table.put("", "D", RequestType.AUTOMATIC_AUTHORISATION_REVERSAL)
    table.put("0101", "A", RequestType.AUTHORISATION_REPEAT)
    table.put("0120", "J", RequestType.AUTHORISATION_ADVICE)
    table.put("0120", "D", RequestType.AUTHORISATION_REVERSAL_FUEL_DISPENSER)
    table.put("0400", "D", RequestType.AUTHORISATION_REVERSAL_REQUEST)
    table.put("0420", "D", RequestType.AUTHORISATION_REVERSAL_ADVICE)
    table.put("1240", "C", RequestType.CHARGEBACK_NOTIFICATION)
    table.put("1240", "H", RequestType.CHARGEBACK_NOTIFICATION_NON_CREDIT)
    table.put("1240", "K", RequestType.CHARGEBACK_REVERSAL)

    listOf("1240", "05  ", "06  ", "07  ").forEach { mtid ->
        table.put(mtid, "A", RequestType.AUTHORISATION_ADVICE_NOTIFICATION)
        table.put(mtid, "P", RequestType.FINANCIAL_NOTIFICATION_FIRST_PRESENTMENT)
        table.put(mtid, "N", RequestType.FINANCIAL_NOTIFICATION_SECOND_PRESENTMENT)
    }

    listOf("1240", "25  ", "26  ", "27  ").forEach { mtid ->
        table.put(mtid, "E", RequestType.FINANCIAL_REVERSAL)
    }

    table.put("", "P", RequestType.FEE_NOTIFICATION)
}

fun GetTransaction.toCardEvent(): CardEvent? =
    when (table.get(mtid ?: "", txnType)) {
        RequestType.AUTHORISATION_REQUEST -> {
            if (sendingAttemptCount > 0) {
                AuthorizationAdvice(traceId, token, date, billingAmount, fees, AuthorizationAdvice.Status.DECLINED_BY_REQUEST
                )
            } else {
                AuthorizationRequest(traceId, token, date, billingAmount, fees)
            }
        }
        RequestType.AUTOMATIC_AUTHORISATION_REVERSAL,
        RequestType.AUTHORISATION_REVERSAL_REQUEST,
        RequestType.AUTHORISATION_REVERSAL_ADVICE,
        RequestType.AUTHORISATION_REVERSAL_FUEL_DISPENSER -> {
            AuthorizationReversal(traceId, token, date, billingAmount, fees)
        }
        RequestType.FINANCIAL_NOTIFICATION_FIRST_PRESENTMENT -> {
            PresentmentNotification(traceId, token, date, billingAmount, fees, false)
        }
        RequestType.FINANCIAL_NOTIFICATION_SECOND_PRESENTMENT -> {
            PresentmentNotification(traceId, token, date, billingAmount, fees, true)
        }
        RequestType.FINANCIAL_REVERSAL -> {
            if (billingAmount.isNegative) throw UnsupportedCardEventException("Financial Reversals can not have a negative billing amount (debit the customer)!")
            PresentmentReversal(traceId, token, date, billingAmount, fees)
        }
        RequestType.AUTHORISATION_ADVICE -> {
            val adviceStatus = when (txnStatCode) {
                "A" -> AuthorizationAdvice.Status.APPROVED
                "I" -> AuthorizationAdvice.Status.DECLINED_BY_ADVICE
                else -> throw UnsupportedCardEventException(
                    "Unsupported txn_stat_code $txnStatCode on authorization advice; must have 'A' or 'I'"
                )
            }
            AuthorizationAdvice(traceId, token, date, billingAmount, fees, adviceStatus)
        }
        RequestType.FEE_NOTIFICATION -> {
            if (!billingAmount.isZero) {
                throw UnsupportedCardEventException("Fee Notifications must have a billing amount of zero!")
            }
            PresentmentNotification(traceId, token, date, billingAmount, fees, false)
        }
        RequestType.AUTHORISATION_ADVICE_NOTIFICATION -> null
        else -> throw UnsupportedCardEventException("Unsupported message type: mtid=$mtid, txnType=$txnType")
    }