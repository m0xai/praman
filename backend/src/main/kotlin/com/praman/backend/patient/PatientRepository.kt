package com.praman.backend.patient

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepository : JpaRepository<Patient, Long> {
    fun findAllByEmail(email: String)
    fun existsByEmail(email: String): Boolean
    fun findByEmail(email: String): Patient
}
