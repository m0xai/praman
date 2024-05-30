package com.praman.backend.doctor

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DoctorRepository : JpaRepository<Doctor, Long> {
    fun existsByEmail(email: String): Boolean
    fun getByEmail(email: String): Doctor
}
