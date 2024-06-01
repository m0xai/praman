package com.praman.backend.user

import com.praman.backend.doctor.DoctorResponse
import com.praman.backend.patient.PatientResponse

data class DoctorUser(
    val id: Long,
    val email: String,
    val username: String,
    val role: String,
    val profile: DoctorResponse,
)

data class PatientUser(
    val id: Long,
    val email: String,
    val username: String,
    val role: String,
    val profile: PatientResponse,
)
