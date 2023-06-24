package com.example.demo.entity.invoices

import com.example.demo.dtos.invoices.InvoiceRequest
import com.example.demo.dtos.invoices.InvoiceResponse
import com.example.demo.entity.invoices.payment_type.PaymentType
import com.example.demo.utils.constants.GlobalConstants.GMT_TIMESTAMP
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.UUID

@Entity
@Table(name = "invoices")
data class InvoiceEntity(
        @Id @GeneratedValue(strategy = GenerationType.UUID)
        val uuid: UUID = UUID.randomUUID(),

        val amount: Long = 0,

        @Column(name = "supplier_name")
        val supplierName: String = "",
        @Column(name = "supplier_ICO")
        val supplierICO: String = "",

        @Column(name = "customer_name")
        val customerName: String = "",
        @Column(name = "customer_ICO")
        val customerICO: String = "",

        @Enumerated(EnumType.STRING) @Column(name = "payment_type")
        val paymentType: PaymentType = PaymentType.PAYMENT_BY_CARD,

        @Column(name = "invoice_date")
        val invoiceDate: ZonedDateTime = ZonedDateTime.now(ZoneId.of(GMT_TIMESTAMP)),
        @Column(name = "invoice_due_date")
        val invoiceDueDate: ZonedDateTime = ZonedDateTime.now(ZoneId.of(GMT_TIMESTAMP)),
        @Column(name = "invoice_fulfillment_date")
        val invoiceFulfillmentDate: ZonedDateTime = ZonedDateTime.now(ZoneId.of(GMT_TIMESTAMP)),

        @CreationTimestamp @Column(name = "created_at", updatable = false)
        val createdAt: ZonedDateTime = ZonedDateTime.now(ZoneId.of(GMT_TIMESTAMP)),
        @UpdateTimestamp @Column(name = "updated_at")
        val updatedAt: ZonedDateTime = ZonedDateTime.now(ZoneId.of(GMT_TIMESTAMP)),
){
        fun toUpdateRequest() = InvoiceRequest(
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

        fun toResponse() = InvoiceResponse(
                uuid = uuid,
                amount = amount,
                supplierName = supplierName,
                supplierICO = supplierICO,
                customerName = customerName,
                customerICO = customerICO,
                paymentType = paymentType,
                invoiceDate = invoiceDate,
                invoiceDueDate = invoiceDueDate,
                invoiceFulfillmentDate = invoiceFulfillmentDate,
                createdAt = createdAt,
                updatedAt = updatedAt,
        )
}
