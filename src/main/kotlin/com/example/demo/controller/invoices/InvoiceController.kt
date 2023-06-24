package com.example.demo.controller.invoices

import com.example.demo.dtos.invoices.InvoiceRequest
import com.example.demo.dtos.invoices.InvoiceResponse
import com.example.demo.service.invoices.InvoiceService
import com.fasterxml.jackson.databind.JsonNode
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/invoices")
class InvoiceController(
        private val invoiceService: InvoiceService,
) {
    @PostMapping
    fun create(@Valid @RequestBody invoiceRequest: InvoiceRequest): InvoiceResponse {
        return invoiceService.create(invoiceRequest)
    }

    /**
     * In this case the Request-Body isn't correctly displayed in swagger
     * The JsonNode will be required as empty {} even if the full requestBody can be filled as InvoiceRequest
     **/
    @PutMapping("/{uuid}")
    fun update(
            @PathVariable("uuid") uuid: UUID,
            @RequestBody invoiceUpdateRequest: JsonNode,
    ): InvoiceResponse {
        return invoiceService.update(uuid, invoiceUpdateRequest)
    }

    @GetMapping("/{uuid}")
    fun findByUuid(@PathVariable("uuid") uuid: UUID): InvoiceResponse {
        return invoiceService.findByUuid(uuid)
    }

    @DeleteMapping("/{uuid}")
    fun deleteByUuid(@PathVariable("uuid") uuid: UUID) {
        return invoiceService.deleteByUuid(uuid)
    }
}