package com.vacuumlabs.gps.ehi.base.utils

import org.javamoney.moneta.Money

operator fun Money.unaryMinus(): Money = this.negate()
operator fun Money.plus(other: Money?): Money {
    return when (other) {
        null -> this
        else -> this.add(other)
    }
}
operator fun Money.minus(other: Money?): Money {
    return when (other) {
        null -> this
        else -> this.minus(other)
    }
}
