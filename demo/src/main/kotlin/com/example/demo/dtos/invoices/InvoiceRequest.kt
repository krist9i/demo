package com.example.demo.dtos.invoices

import com.example.demo.entity.invoices.InvoiceEntity
import com.example.demo.entity.invoices.payment_type.PaymentType
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Pattern
import java.time.ZonedDateTime

data class InvoiceRequest(
        val amount: Long,

        @Max(value = 255, message = "The number of characters is bigger than 255.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]{1,255}\$", message = "At least one of the characters in parameter 'supplierName' is prohibited.")
        val supplierName: String,
        @Max(value = 255, message = "The number of characters is bigger than 255.")
        @Pattern(regexp = "^[A-Z0-9]{8,21}\$", message = "At least one of the characters in parameter 'supplierName' is prohibited.")
        val supplierICO: String,

        @Max(value = 255, message = "The number of characters is bigger than 255.")
        @Pattern(regexp = "^[a-zA-Z0-9 ]{1,255}\$", message = "At least one of the characters in parameter 'supplierName' is prohibited.")
        val customerName: String,
        @Max(value = 255, message = "The number of characters is bigger than 255.")
        @Pattern(regexp = "^[A-Z0-9]{8,21}\$", message = "At least one of the characters in parameter 'supplierName' is prohibited.")
        val customerICO: String,

        val paymentType: PaymentType,

        val invoiceDate: ZonedDateTime,
        val invoiceDueDate: ZonedDateTime,
        val invoiceFulfillmentDate: ZonedDateTime,
){
        fun toEntity(entity: InvoiceEntity): InvoiceEntity {
                return entity.copy(
                        amount = amount,
                        supplierName = supplierName,
                        supplierICO = supplierICO,
                        customerName = customerName,
                        customerICO = customerICO,
                        paymentType = paymentType,
                        invoiceDate = invoiceDate,
                        invoiceDueDate = invoiceDueDate,
                        invoiceFulfillmentDate = invoiceFulfillmentDate,
                )
        }

        fun toEntity() = InvoiceEntity(
                amount = amount,
                supplierName = supplierName,
                supplierICO = supplierICO,
                customerName = customerName,
                customerICO = customerICO,
                paymentType = paymentType,
                invoiceDate = invoiceDate,
                invoiceDueDate = invoiceDueDate,
                invoiceFulfillmentDate = invoiceFulfillmentDate,
        )
}
