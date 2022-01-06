package com.vacuumlabs.gps.ehi.base.events

import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.javamoney.moneta.Money
import java.time.LocalDateTime

interface CardEvent {
    val traceId: String
    val token: String
    val date: LocalDateTime
    val amount: Money
    val fees: Fees
}

data class Fees(
    val fixed: Money?,
    val rate: Money?,
    val fxPad: Money?,
    val mccPad: Money?,
    val interchange: Money?
)

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
sealed class AsyncCardEvent : CardEvent

data class AuthorizationRequest(
    override val traceId: String,
    override val token: String,
    override val date: LocalDateTime,
    override val amount: Money,
    override val fees: Fees,
) : CardEvent

data class AuthorizationAdvice(
    override val traceId: String,
    override val token: String,
    override val date: LocalDateTime,
    override val amount: Money,
    override val fees: Fees,
    val status: Status,
) : AsyncCardEvent() {
    enum class Status {
        APPROVED,
        DECLINED_BY_ADVICE,
        DECLINED_BY_REQUEST,
    }
}

data class AuthorizationReversal(
    override val traceId: String,
    override val token: String,
    override val date: LocalDateTime,
    override val amount: Money,
    override val fees: Fees,
) : AsyncCardEvent()

data class PresentmentNotification(
    override val traceId: String,
    override val token: String,
    override val date: LocalDateTime,
    override val amount: Money,
    override val fees: Fees,
    val isFinal: Boolean,
) : AsyncCardEvent()

data class PresentmentReversal(
    override val traceId: String,
    override val token: String,
    override val date: LocalDateTime,
    override val amount: Money,
    override val fees: Fees,
) : AsyncCardEvent()
