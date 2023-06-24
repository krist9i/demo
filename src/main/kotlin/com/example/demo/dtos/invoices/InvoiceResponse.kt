package com.example.demo.dtos.invoices

import com.example.demo.entity.invoices.payment_type.PaymentType
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime
import java.util.UUID

data class InvoiceResponse(
        val uuid: UUID,

        val amount: Long,

        val supplierName: String,
        val supplierICO: String,

        val customerName: String,
        val customerICO: String,

        val paymentType: PaymentType,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ") val invoiceDate: ZonedDateTime,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ") val invoiceDueDate: ZonedDateTime,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ") val invoiceFulfillmentDate: ZonedDateTime,

        val createdAt: ZonedDateTime,
        val updatedAt: ZonedDateTime,
)
