package com.example.demo.component.invoices

import com.example.demo.dtos.invoices.InvoiceRequest
import com.example.demo.entity.invoices.InvoiceEntity
import com.example.demo.repository.invoices.InvoiceRepository
import com.example.demo.utils.exceptions.NotFoundException
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class InvoiceComponent(
        private val invoiceRepository: InvoiceRepository,
) {
    fun create(invoiceEntity: InvoiceEntity): InvoiceEntity {
        return invoiceRepository.save(invoiceEntity)
    }

    fun update(entity: InvoiceEntity, mergedEntity: InvoiceRequest): InvoiceEntity {
        return invoiceRepository.save(mergedEntity.toEntity(entity))
    }

    fun findByUuid(uuid: UUID): InvoiceEntity {
        return invoiceRepository.findByUuid(uuid)
                ?: throw NotFoundException("Invoice with uuid $uuid was not found.")
    }

    fun deleteByUuid(uuid: UUID) {
        val result = findByUuid(uuid)
        invoiceRepository.delete(result)
    }
}