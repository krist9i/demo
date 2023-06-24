package com.example.demo.service.invoices

import com.example.demo.dtos.invoices.InvoiceRequest
import com.example.demo.dtos.invoices.InvoiceResponse
import com.fasterxml.jackson.databind.JsonNode
import java.util.UUID

interface InvoiceService {
    fun create(invoiceRequest: InvoiceRequest): InvoiceResponse

    fun update(uuid: UUID, invoicePatchRequest: JsonNode): InvoiceResponse

    fun findByUuid(uuid: UUID): InvoiceResponse

    fun deleteByUuid(uuid: UUID)
}