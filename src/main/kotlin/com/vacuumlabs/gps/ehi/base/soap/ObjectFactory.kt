package com.vacuumlabs.gps.ehi.base.soap

import javax.xml.bind.annotation.XmlRegistry

@XmlRegistry
class ObjectFactory {
    fun createGetTransaction() = GetTransaction()

    fun createGetTransactionResponse() = GetTransactionResponse()

    fun createResponseMsg() = ResponseMsg()
}
