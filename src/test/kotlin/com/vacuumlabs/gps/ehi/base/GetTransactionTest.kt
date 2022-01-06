package com.vacuumlabs.gps.ehi.base

import com.vacuumlabs.gps.ehi.base.Constants.ERROR_MISSING_REQUIRED_VALUE
import com.vacuumlabs.gps.ehi.base.soap.GetTransaction
import com.vacuumlabs.gps.ehi.base.utils.InvalidInputException
import org.springframework.validation.FieldError
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class GetTransactionTest {
    @Test
    fun `multiple validation errors`() {
        val errors = assertThrows<InvalidInputException> {
            GetTransaction().validate()
        }.errors.allErrors.associateBy(
            keySelector = {
                if (it is FieldError) {
                    it.field
                } else {
                    null
                }
            },
            valueTransform = { it.defaultMessage }
        )
        println(errors)
        assertEquals(
            mapOf(
                "SendingAttemptCount" to ERROR_MISSING_REQUIRED_VALUE,
                "Token" to ERROR_MISSING_REQUIRED_VALUE,
                "Txn_Type" to ERROR_MISSING_REQUIRED_VALUE,
                "Txn_Stat_Code" to ERROR_MISSING_REQUIRED_VALUE,
                "traceid_lifecycle" to ERROR_MISSING_REQUIRED_VALUE,
                "Txn_GPS_Date" to ERROR_MISSING_REQUIRED_VALUE,
                "Bill_Ccy" to ERROR_MISSING_REQUIRED_VALUE,
            ),
            errors,
            "errors"
        )
    }
}