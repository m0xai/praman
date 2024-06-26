package com.praman.backend.appointment

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AppointmentRepository : JpaRepository<Appointment, Long> {
    fun findAllByPatientEmail(email: String): List<Appointment>
    fun findAllByDoctorEmail(doctorEmail: String): List<Appointment>
}
