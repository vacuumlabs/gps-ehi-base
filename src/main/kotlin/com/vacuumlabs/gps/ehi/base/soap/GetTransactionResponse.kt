package com.vacuumlabs.gps.ehi.base.soap

import com.fasterxml.jackson.annotation.JsonProperty
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlType


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = [])
@XmlRootElement(name = "GetTransactionResponse")
data class GetTransactionResponse(
    @field:XmlElement(name = "GetTransactionResult", required = true)
    @JsonProperty("GetTransactionResult")
    val getTransactionResult: ResponseMsg? = null
)
