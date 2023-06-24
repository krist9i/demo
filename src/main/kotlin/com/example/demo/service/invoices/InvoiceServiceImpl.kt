package com.example.demo.service.invoices

import com.example.demo.component.invoices.InvoiceComponent
import com.example.demo.dtos.invoices.InvoiceRequest
import com.example.demo.dtos.invoices.InvoiceResponse
import com.example.demo.utils.utils.mergePatch
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.stereotype.Service
import java.util.*

@Service
class InvoiceServiceImpl(
        private val invoiceComponent: InvoiceComponent,
): InvoiceService {
    override fun create(invoiceRequest: InvoiceRequest): InvoiceResponse {
        val result = invoiceComponent.create(invoiceRequest.toEntity())
        return result.toResponse()
    }

    override fun update(uuid: UUID, invoicePatchRequest: JsonNode): InvoiceResponse {
        val entity = invoiceComponent.findByUuid(uuid)

        val mergedEntity = mergePatch(entity.toUpdateRequest(), invoicePatchRequest, InvoiceRequest::class.java)
        val result = invoiceComponent.update(entity, mergedEntity)

        return result.toResponse()
    }

    override fun findByUuid(uuid: UUID): InvoiceResponse {
        val result = invoiceComponent.findByUuid(uuid)
        return result.toResponse()
    }

    override fun deleteByUuid(uuid: UUID) {
        invoiceComponent.deleteByUuid(uuid)
    }
}