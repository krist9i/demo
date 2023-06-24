package com.example.demo.repository.invoices

import com.example.demo.entity.invoices.InvoiceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface InvoiceRepository: JpaRepository<InvoiceEntity, UUID> {
    fun findByUuid(uuid: UUID): InvoiceEntity?
}