package com.example.demo.controller.invoices

import com.example.demo.dtos.invoices.InvoiceRequest
import com.example.demo.dtos.invoices.InvoiceResponse
import com.example.demo.service.invoices.InvoiceService
import com.fasterxml.jackson.databind.JsonNode
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/invoices")
class InvoiceController(
        private val invoiceService: InvoiceService,
) {
    @PostMapping
    fun create(@Valid @RequestBody invoiceRequest: InvoiceRequest): InvoiceResponse {
        return invoiceService.create(invoiceRequest)
    }

    @PutMapping("/{uuid}")
    fun update(
            @PathVariable("uuid") uuid: UUID,
            @RequestBody invoiceUpdateRequest: JsonNode
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