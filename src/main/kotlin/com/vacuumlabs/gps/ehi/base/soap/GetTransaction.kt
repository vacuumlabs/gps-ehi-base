package com.vacuumlabs.gps.ehi.base.soap

import com.vacuumlabs.gps.ehi.base.events.Fees
import com.vacuumlabs.gps.ehi.base.Constants.ERROR_MISSING_REQUIRED_VALUE
import com.vacuumlabs.gps.ehi.base.utils.InvalidInputException
import com.vacuumlabs.gps.ehi.base.utils.bigDecimal
import com.vacuumlabs.gps.ehi.base.utils.currency
import com.vacuumlabs.gps.ehi.base.utils.date
import com.vacuumlabs.gps.ehi.base.utils.int
import org.javamoney.moneta.Money
import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.FieldError
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient
import javax.xml.bind.annotation.XmlType
import kotlin.reflect.KProperty0
import com.fasterxml.jackson.annotation.JsonProperty as Json
import javax.xml.bind.annotation.XmlElement as Xml

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = [])
@XmlRootElement(name = "GetTransaction")
data class GetTransaction(
    @field:Xml(name = "AVS_Result") @Json("AVS_Result")
    val avsResult: String? = null,
    @field:Xml(name = "Acquirer_Forwarder_ID") @Json("Acquirer_Forwarder_ID")
    val acquirerForwarderID: String? = null,
    @field:Xml(name = "Acquirer_Reference_Data_031") @Json("Acquirer_Reference_Data_031")
    val acquirerReferenceData031: String? = null,
    @field:Xml(name = "Acquirer_id_DE32") @Json("Acquirer_id_DE32")
    val acquirerIdDE32: String? = null,
    @field:Xml(name = "ActBal") @Json("ActBal")
    val actBal: Double = 0.0,
    @field:Xml(name = "Additional_Amt_DE54") @Json("Additional_Amt_DE54")
    val additionalAmtDE54: String? = null,
    @field:Xml(name = "Additional_Data_DE124") @Json("Additional_Data_DE124")
    val additionalDataDE124: String? = null,
    @field:Xml(name = "Additional_Data_DE48") @Json("Additional_Data_DE48")
    val additionalDataDE48: String? = null,
    @field:Xml(name = "Amt_Tran_Fee_DE28") @Json("Amt_Tran_Fee_DE28")
    val amtTranFeeDE28: String? = null,
    @field:Xml(name = "Auth_Code_DE38") @Json("Auth_Code_DE38")
    val authCodeDE38: String? = null,
    @field:Xml(name = "Authorised_by_GPS") @Json("Authorised_by_GPS")
    val authorisedByGPS: String? = null,
    @field:Xml(name = "Avl_Bal") @Json("Avl_Bal")
    val avlBal: Double = 0.0,
    @field:Xml(name = "Balance_Sequence") @Json("Balance_Sequence")
    val balanceSequence: Long? = null,
    @field:Xml(name = "Balance_Sequence_Exthost") @Json("Balance_Sequence_Exthost")
    val balanceSequenceExthost: Long? = null,
    @field:Xml(name = "Bill_Amt") @Json("Bill_Amt")
    val billAmt: String? = null,
    @field:Xml(name = "Bill_Ccy") @Json("Bill_Ccy")
    val billCcy: String? = null,
    @field:Xml(name = "BlkAmt") @Json("BlkAmt")
    val blkAmt: Double = 0.0,
    @field:Xml(name = "CU_Group") @Json("CU_Group")
    val cuGroup: String? = null,
    @field:Xml(name = "CVV2") @Json("CVV2")
    val cvv2: String? = null,
    @field:Xml(name = "Clearing_Process_Date") @Json("Clearing_Process_Date")
    val clearingProcessDate: String? = null,
    @field:Xml(name = "Currency_Code_Fee") @Json("Currency_Code_Fee")
    val currencyCodeFee: String? = null,
    @field:Xml(name = "Currency_Code_Fee_Settlement") @Json("Currency_Code_Fee_Settlement")
    val currencyCodeFeeSettlement: String? = null,
    @field:Xml(name = "Cust_Ref") @Json("Cust_Ref")
    val custRef: String? = null,
    @field:Xml(name = "DCC_Indicator") @Json("DCC_Indicator")
    val dccIndicator: String? = null,
    @field:Xml(name = "Dispute_Condition") @Json("Dispute_Condition")
    val disputeCondition: String? = null,
    @field:Xml(name = "Dom_Fee_Fixed") @Json("Dom_Fee_Fixed")
    val domFeeFixed: String? = null,
    @field:Xml(name = "Dom_Fee_Rate") @Json("Dom_Fee_Rate")
    val domFeeRate: String? = null,
    @field:Xml(name = "Expiry_Date") @Json("Expiry_Date")
    val expiryDate: String? = null,
    @field:Xml(name = "FX_Pad") @Json("FX_Pad")
    val fxPad: String? = null,
    @field:Xml(name = "Fee_Fixed") @Json("Fee_Fixed")
    val feeFixed: String? = null,
    @field:Xml(name = "Fee_Rate") @Json("Fee_Rate")
    val feeRate: String? = null,
    @field:Xml(name = "Fx_Fee_Fixed") @Json("Fx_Fee_Fixed")
    val fxFeeFixed: String? = null,
    @field:Xml(name = "Fx_Fee_Rate") @Json("Fx_Fee_Rate")
    val fxFeeRate: String? = null,
    @field:Xml(name = "GPS_POS_Capability") @Json("GPS_POS_Capability")
    val gpsposCapability: String? = null,
    @field:Xml(name = "GPS_POS_Data") @Json("GPS_POS_Data")
    val gpsposData: String? = null,
    @field:Xml(name = "ICC_System_Related_Data_DE55") @Json("ICC_System_Related_Data_DE55")
    val iccSystemRelatedDataDE55: String? = null,
    @field:Xml(name = "InstCode") @Json("InstCode")
    val instCode: String? = null,
    @field:Xml(name = "Interchange_Amount_Fee") @Json("Interchange_Amount_Fee")
    val interchangeAmountFee: String? = null,
    @field:Xml(name = "Interchange_Amount_Fee_Settlement") @Json("Interchange_Amount_Fee_Settlement")
    val interchangeAmountFeeSettlement: String? = null,
    @field:Xml(name = "LoadSRC") @Json("LoadSRC")
    val loadSRC: String? = null,
    @field:Xml(name = "LoadType") @Json("LoadType")
    val loadType: String? = null,
    @field:Xml(name = "MCC_Code") @Json("MCC_Code")
    val mccCode: String? = null,
    @field:Xml(name = "MCC_Desc") @Json("MCC_Desc")
    val mccDesc: String? = null,
    @field:Xml(name = "MCC_Pad") @Json("MCC_Pad")
    val mccPad: String? = null,
    @field:Xml(name = "MTID") @Json("MTID")
    val rawMtid: String? = null,
    @field:Xml(name = "Mastercard_AdviceReasonCode_DE60") @Json("Mastercard_AdviceReasonCode_DE60")
    val mastercardAdviceReasonCodeDE60: String? = null,
    @field:Xml(name = "Matching_Txn_ID") @Json("Matching_Txn_ID")
    val matchingTxnID: String? = null,
    @field:Xml(name = "Merch_City") @Json("Merch_City")
    val merchCity: String? = null,
    @field:Xml(name = "Merch_Contact") @Json("Merch_Contact")
    val merchContact: String? = null,
    @field:Xml(name = "Merch_Country") @Json("Merch_Country")
    val merchCountry: String? = null,
    @field:Xml(name = "Merch_ID_DE42") @Json("Merch_ID_DE42")
    val merchIDDE42: String? = null,
    @field:Xml(name = "Merch_Name") @Json("Merch_Name")
    val merchName: String? = null,
    @field:Xml(name = "Merch_Name_DE43") @Json("Merch_Name_DE43")
    val merchNameDE43: String? = null,
    @field:Xml(name = "Merch_Name_Other") @Json("Merch_Name_Other")
    val merchNameOther: String? = null,
    @field:Xml(name = "Merch_Net_id") @Json("Merch_Net_id")
    val merchNetId: String? = null,
    @field:Xml(name = "Merch_Postcode") @Json("Merch_Postcode")
    val merchPostcode: String? = null,
    @field:Xml(name = "Merch_Region") @Json("Merch_Region")
    val merchRegion: String? = null,
    @field:Xml(name = "Merch_Street") @Json("Merch_Street")
    val merchStreet: String? = null,
    @field:Xml(name = "Merch_Tax_id") @Json("Merch_Tax_id")
    val merchTaxId: String? = null,
    @field:Xml(name = "Merch_Tel") @Json("Merch_Tel")
    val merchTel: String? = null,
    @field:Xml(name = "Merch_URL") @Json("Merch_URL")
    val merchURL: String? = null,
    @field:Xml(name = "Message_Source") @Json("Message_Source")
    val messageSource: String? = null,
    @field:Xml(name = "Message_Why") @Json("Message_Why")
    val messageWhy: String? = null,
    @field:Xml(name = "Misc_TLV_Data") @Json("Misc_TLV_Data")
    val miscTLVData: String? = null,
    @field:Xml(name = "Network_BaseAmt_To_BillAmt_Rate") @Json("Network_BaseAmt_To_BillAmt_Rate")
    val networkBaseAmtToBillAmtRate: String? = null,
    @field:Xml(name = "Network_Chargeback_Reference_Id") @Json("Network_Chargeback_Reference_Id")
    val networkChargebackReferenceId: String? = null,
    @field:Xml(name = "Network_Currency_Conversion_Date") @Json("Network_Currency_Conversion_Date")
    val networkCurrencyConversionDate: String? = null,
    @field:Xml(name = "Network_Issuer_Settle_ID") @Json("Network_Issuer_Settle_ID")
    val networkIssuerSettleID: String? = null,
    @field:Xml(name = "Network_Original_Data_Elements_DE90") @Json("Network_Original_Data_Elements_DE90")
    val networkOriginalDataElementsDE90: String? = null,
    @field:Xml(name = "Network_Replacement_Amounts_DE95") @Json("Network_Replacement_Amounts_DE95")
    val networkReplacementAmountsDE95: String? = null,
    @field:Xml(name = "Network_Transaction_ID") @Json("Network_Transaction_ID")
    val networkTransactionID: String? = null,
    @field:Xml(name = "Network_TxnAmt_To_BaseAmt_Rate") @Json("Network_TxnAmt_To_BaseAmt_Rate")
    val networkTxnAmtToBaseAmtRate: String? = null,
    @field:Xml(name = "Network_TxnAmt_To_BillAmt_Rate") @Json("Network_TxnAmt_To_BillAmt_Rate")
    val networkTxnAmtToBillAmtRate: String? = null,
    @field:Xml(name = "Non_Dom_Fee_Fixed") @Json("Non_Dom_Fee_Fixed")
    val nonDomFeeFixed: String? = null,
    @field:Xml(name = "Non_Dom_Fee_Rate") @Json("Non_Dom_Fee_Rate")
    val nonDomFeeRate: String? = null,
    @field:Xml(name = "Note") @Json("Note")
    val note: String? = null,
    @field:Xml(name = "Other_Fee_Amt") @Json("Other_Fee_Amt")
    val otherFeeAmt: String? = null,
    @field:Xml(name = "PAN_Sequence_Number") @Json("PAN_Sequence_Number")
    val panSequenceNumber: String? = null,
    @field:Xml(name = "PIN") @Json("PIN")
    val pin: String? = null,
    @field:Xml(name = "PIN_Enc_Algorithm") @Json("PIN_Enc_Algorithm")
    val pinEncAlgorithm: String? = null,
    @field:Xml(name = "PIN_Format") @Json("PIN_Format")
    val pinFormat: String? = null,
    @field:Xml(name = "PIN_Key_Index") @Json("PIN_Key_Index")
    val pinKeyIndex: String? = null,
    @field:Xml(name = "POS_Data_DE22") @Json("POS_Data_DE22")
    val posDataDE22: String? = null,
    @field:Xml(name = "POS_Data_DE61") @Json("POS_Data_DE61")
    val posDataDE61: String? = null,
    @field:Xml(name = "POS_Date_DE13") @Json("POS_Date_DE13")
    val posDateDE13: String? = null,
    @field:Xml(name = "POS_Termnl_DE41") @Json("POS_Termnl_DE41")
    val posTermnlDE41: String? = null,
    @field:Xml(name = "POS_Time_DE12") @Json("POS_Time_DE12")
    val posTimeDE12: String? = null,
    @field:Xml(name = "PaymentToken_activationCode") @Json("PaymentToken_activationCode")
    val paymentTokenActivationCode: String? = null,
    @field:Xml(name = "PaymentToken_activationExpiry") @Json("PaymentToken_activationExpiry")
    val paymentTokenActivationExpiry: String? = null,
    @field:Xml(name = "PaymentToken_activationMethod") @Json("PaymentToken_activationMethod")
    val paymentTokenActivationMethod: String? = null,
    @field:Xml(name = "PaymentToken_activationMethodData") @Json("PaymentToken_activationMethodData")
    val paymentTokenActivationMethodData: String? = null,
    @field:Xml(name = "PaymentToken_creator") @Json("PaymentToken_creator")
    val paymentTokenCreator: String? = null,
    @field:Xml(name = "PaymentToken_creatorStatus") @Json("PaymentToken_creatorStatus")
    val paymentTokenCreatorStatus: String? = null,
    @field:Xml(name = "PaymentToken_deviceId") @Json("PaymentToken_deviceId")
    val paymentTokenDeviceId: String? = null,
    @field:Xml(name = "PaymentToken_deviceIp") @Json("PaymentToken_deviceIp")
    val paymentTokenDeviceIp: String? = null,
    @field:Xml(name = "PaymentToken_deviceName") @Json("PaymentToken_deviceName")
    val paymentTokenDeviceName: String? = null,
    @field:Xml(name = "PaymentToken_deviceTelNum") @Json("PaymentToken_deviceTelNum")
    val paymentTokenDeviceTelNum: String? = null,
    @field:Xml(name = "PaymentToken_deviceType") @Json("PaymentToken_deviceType")
    val paymentTokenDeviceType: String? = null,
    @field:Xml(name = "PaymentToken_expdate") @Json("PaymentToken_expdate")
    val paymentTokenExpdate: String? = null,
    @field:Xml(name = "PaymentToken_id") @Json("PaymentToken_id")
    val paymentTokenId: String? = null,
    @field:Xml(name = "PaymentToken_lang") @Json("PaymentToken_lang")
    val paymentTokenLang: String? = null,
    @field:Xml(name = "PaymentToken_status") @Json("PaymentToken_status")
    val paymentTokenStatus: String? = null,
    @field:Xml(name = "PaymentToken_type") @Json("PaymentToken_type")
    val paymentTokenType: String? = null,
    @field:Xml(name = "PaymentToken_wallet") @Json("PaymentToken_wallet")
    val paymentTokenWallet: String? = null,
    @field:Xml(name = "Proc_Code") @Json("Proc_Code")
    val procCode: String? = null,
    @field:Xml(name = "ProductID") @Json("ProductID")
    val productID: Int = 0,
    @field:Xml(name = "Reason_ID") @Json("Reason_ID")
    val reasonID: String? = null,
    @field:Xml(name = "Record_Data_DE120") @Json("Record_Data_DE120")
    val recordDataDE120: String? = null,
    @field:Xml(name = "Resp_Code_DE39") @Json("Resp_Code_DE39")
    val respCodeDE39: String? = null,
    @field:Xml(name = "Response_Source") @Json("Response_Source")
    val responseSource: String? = null,
    @field:Xml(name = "Response_Source_Why") @Json("Response_Source_Why")
    val responseSourceWhy: String? = null,
    @field:Xml(name = "Ret_Ref_No_DE37") @Json("Ret_Ref_No_DE37")
    val retRefNoDE37: String? = null,
    @field:Xml(name = "SendingAttemptCount") @Json("SendingAttemptCount")
    val rawSendingAttemptCount: String? = null,
    @field:Xml(name = "Settle_Amt") @Json("Settle_Amt")
    val settleAmt: Double = 0.0,
    @field:Xml(name = "Settle_Ccy") @Json("Settle_Ccy")
    val settleCcy: String? = null,
    @field:Xml(name = "SettlementIndicator") @Json("SettlementIndicator")
    val settlementIndicator: String? = null,
    @field:Xml(name = "Settlement_Date") @Json("Settlement_Date")
    val settlementDate: String? = null,
    @field:Xml(name = "Status_Code") @Json("Status_Code")
    val statusCode: String? = null,
    @field:Xml(name = "SubBIN") @Json("SubBIN")
    val subBIN: Long = 0,
    @field:Xml(name = "TLogIDOrg") @Json("TLogIDOrg")
    val tLogIDOrg: String? = null,
    @field:Xml(name = "TXN_Time_DE07") @Json("TXN_Time_DE07")
    val txnTimeDE07: String? = null,
    @field:Xml(name = "TXn_ID") @Json("TXn_ID")
    val txnId: String? = null,
    @field:Xml(name = "Token") @Json("Token")
    val rawToken: String? = null,
    @field:Xml(name = "Traceid_Message") @Json("Traceid_Message")
    val traceidMessage: String? = null,
    @field:Xml(name = "Traceid_Original") @Json("Traceid_Original")
    val traceidOriginal: String? = null,
    @field:Xml(name = "Trans_link") @Json("Trans_link")
    val transLink: String? = null,
    @field:Xml(name = "Txn_Amt") @Json("Txn_Amt")
    val txnAmt: BigDecimal? = null,
    @field:Xml(name = "Txn_CCy") @Json("Txn_CCy")
    val txnCCy: String? = null,
    @field:Xml(name = "Txn_Ctry") @Json("Txn_Ctry")
    val txnCtry: String? = null,
    @field:Xml(name = "Txn_Desc") @Json("Txn_Desc")
    val txnDesc: String? = null,
    @field:Xml(name = "Txn_GPS_Date") @Json("Txn_GPS_Date")
    val txnGPSDate: String? = null,
    @field:Xml(name = "Txn_Stat_Code") @Json("Txn_Stat_Code")
    val rawTxnStatCode: String? = null,
    @field:Xml(name = "Txn_Type") @Json("Txn_Type")
    val rawTxnType: String? = null,
    @field:Xml(name = "VL_Group") @Json("VL_Group")
    val vlGroup: String? = null,
    @field:Xml(name = "Visa_POS_Data_DE60") @Json("Visa_POS_Data_DE60")
    val visaPOSDataDE60: String? = null,
    @field:Xml(name = "Visa_ResponseInfo_DE44") @Json("Visa_ResponseInfo_DE44")
    val visaResponseInfoDE44: String? = null,
    @field:Xml(name = "Visa_STIP_Reason_Code") @Json("Visa_STIP_Reason_Code")
    val visaSTIPReasonCode: String? = null,
    @field:Xml(name = "auth_expdate_utc") @Json("auth_expdate_utc")
    val authExpdateUtc: String? = null,
    @field:Xml(name = "auth_type") @Json("auth_type")
    val authType: String? = null,
    @field:Xml(name = "dest_bank_account") @Json("dest_bank_account")
    val destBankAccount: String? = null,
    @field:Xml(name = "dest_bank_account_format") @Json("dest_bank_account_format")
    val destBankAccountFormat: String? = null,
    @field:Xml(name = "dest_bank_ctry") @Json("dest_bank_ctry")
    val destBankCtry: String? = null,
    @field:Xml(name = "multi_part_count") @Json("multi_part_count")
    val multiPartCount: String? = null,
    @field:Xml(name = "multi_part_number") @Json("multi_part_number")
    val multiPartNumber: String? = null,
    @field:Xml(name = "multi_part_txn") @Json("multi_part_txn")
    val multiPartTxn: String? = null,
    @field:Xml(name = "multi_part_txn_final") @Json("multi_part_txn_final")
    val multiPartTxnFinal: String? = null,
    @field:Xml(name = "source_bank_account") @Json("source_bank_account")
    val sourceBankAccount: String? = null,
    @field:Xml(name = "source_bank_account_format") @Json("source_bank_account_format")
    val sourceBankAccountFormat: String? = null,
    @field:Xml(name = "source_bank_ctry") @Json("source_bank_ctry")
    val sourceBankCtry: String? = null,
    @field:Xml(name = "traceid_lifecycle") @Json("traceid_lifecycle")
    val traceIdLifeCycle: String? = null,
    @field:Xml(name = "Acquirer_Country") @Json("Acquirer_Country")
    val acquirerCountry: String? = null,
    @field:Xml(name = "ClearingFileID") @Json("ClearingFileID")
    val clearingFileId: String? = null,
    @field:Xml(name = "Network_Fraud_Data") @Json("Network_Fraud_Data")
    val networkFraudData: String? = null,
    @field:Xml(name = "PaymentToken_PanSource") @Json("PaymentToken_PanSource")
    val paymentTokenPanSource: Int? = null,
    @field:Xml(name = "ReceiverData") @Json("ReceiverData")
    val receiverData: String? = null,
    @field:Xml(name = "SenderData") @Json("SenderData")
    val senderData: String? = null,
    @field:Xml(name = "AuthenticationCurrency") @Json("AuthenticationCurrency")
    val authenticationCurrency: Int? = null,
    @field:Xml(name = "AuthenticationAmountUpper") @Json("AuthenticationAmountUpper")
    val authenticationAmountUpper: BigDecimal? = null,
    @field:Xml(name = "AuthenticationMerchantHash") @Json("AuthenticationMerchantHash")
    val authenticationMerchantHash: String? = null,
    @field:Xml(name = "FxProviderCardholderRate") @Json("FxProviderCardholderRate")
    val fxProviderCardholderRate: BigDecimal? = null,
    @field:Xml(name = "FxProviderBookedRate") @Json("FxProviderBookedRate")
    val fxProviderBookedRate: BigDecimal? = null
) {
    @delegate:XmlTransient
    val sendingAttemptCount: Int by lazy { propFail(::rawSendingAttemptCount) { it.required.int } }

    @delegate:XmlTransient
    val token: String by lazy { propFail(::rawToken) { it.nullIfBlank.required } }

    @delegate:XmlTransient
    val mtid: String? by lazy { rawMtid.nullIfBlank }

    @delegate:XmlTransient
    val txnStatCode by lazy { propFail(::rawTxnStatCode) { it.nullIfBlank.required } }

    @delegate:XmlTransient
    val txnType: String by lazy { propFail(::rawTxnType) { it.nullIfBlank.required } }

    @delegate:XmlTransient
    val traceId: String by lazy { propFail(::traceIdLifeCycle) { it.nullIfBlank.required } }

    @delegate:XmlTransient
    val date: LocalDateTime by lazy { propFail(::txnGPSDate) { it.required.date } }

    @delegate:XmlTransient
    val billingAmount: Money by lazy {
        money(::billAmt, ::billCcy, required = true)!!
    }

    @delegate:XmlTransient
    val fees: Fees by lazy {
        Fees(
            money(::feeFixed, ::billCcy),
            money(::feeRate, ::billCcy),
            money(::fxPad, ::billCcy),
            money(::mccPad, ::billCcy),
            money(::interchangeAmountFee, ::currencyCodeFee)
        )
    }

    fun money(amtProp: KProperty0<String?>, ccyProp: KProperty0<String?>, required: Boolean = false) = propFail(ccyProp) {
        it.nullIfBlank.let { ccy ->
            if (required) ccy.required else ccy
        }?.currency
    }?.let { ccy ->
        Money.of(
            propFail(amtProp) { amtValue -> amtValue.nullIfBlank?.bigDecimal ?: BigDecimal.ZERO },
            ccy
        )
    }

    private val <T> T?.required: T
        get() = this ?: throw IllegalArgumentException(ERROR_MISSING_REQUIRED_VALUE)

    private val String?.nullIfBlank: String?
        get() = if (isNullOrBlank()) null else this

    fun validate() {
        val allErrors = BeanPropertyBindingResult(this, "GetTransaction")
        listOf(
            ::sendingAttemptCount,
            ::token,
            ::traceId,
            ::txnType,
            ::txnStatCode,
            ::traceId,
            ::date,
            ::billingAmount,
            ::fees
        ).forEach {
            try {
                it.get()
            } catch (e: InvalidInputException) {
                allErrors.addAllErrors(e.errors)
            }
        }
        if (allErrors.hasErrors()) {
            throw InvalidInputException(allErrors)
        }
    }

    private fun <T, R> propFail(prop: KProperty0<T>, getter: (T) -> R): R {
        return try {
            getter.invoke(prop.get())
        } catch (e: Throwable) {
            val fieldName = GetTransaction::class.java.declaredFields.find { it.name == prop.name }!!.annotations.filterIsInstance<Xml>().first().name
            throw InvalidInputException(
                BeanPropertyBindingResult(this@GetTransaction, "GetTransaction").also {
                    it.addError(FieldError("GetTransaction", fieldName, prop.get(), false, null, null, e.message))
                }
            )
        }
    }
}
