package com.vacuumlabs.gps.ehi.base.soap

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlType

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseMsg", propOrder = [])
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ResponseMsg(
    @field:XmlElement(name = "Responsestatus")
    @JsonProperty("Responsestatus")
    val responsestatus: String? = null,

    @field:XmlElement(name = "CurBalance")
    @JsonProperty("CurBalance")
    val curBalance: Double? = null,

    @field:XmlElement(name = "AvlBalance")
    @JsonProperty("AvlBalance")
    val avlBalance: Double? = null,

    @field:XmlElement(name = "Acknowledgement", required = true)
    @JsonProperty("Acknowledgement")
    val acknowledgement: String? = null,

    @field:XmlElement(name = "LoadAmount")
    @JsonProperty("LoadAmount")
    val loadAmount: Double? = null,

    @field:XmlElement(name = "Bill_Amt_Approved")
    @JsonProperty("Bill_Amt_Approved")
    val billAmtApproved: Double? = null,

    @field:XmlElement(name = "Update_Balance")
    @JsonProperty("Update_Balance")
    val updateBalance: Int? = null,

    @field:XmlElement(name = "New_Balance_Sequence_Exthost")
    @JsonProperty("New_Balance_Sequence_Exthost")
    val newBalanceSequenceExthost: String? = null,

    @field:XmlElement(name = "CVV2_Result")
    @JsonProperty("CVV2_Result")
    val cvv2Result: String? = null,

    @field:XmlElement(name = "AvlBalance_GPS_STIP")
    @JsonProperty("AvlBalance_GPS_STIP")
    val avlBalanceGPSSTIP: Double? = null,

    @field:XmlElement(name = "CurBalance_GPS_STIP")
    @JsonProperty("CurBalance_GPS_STIP")
    val curBalanceGPSSTIP: Double? = null
)
