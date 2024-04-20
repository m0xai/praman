package com.praman.backend.patient

import java.util.*

data class PatientCreateRequest(
        val fullName: String,
        val dateOfBirth: Date
)

fun PatientCreateRequest.toEntity() = Patient(
        fullName = fullName,
        dateOfBirth = dateOfBirth
)

data class PatientUpdateRequest(
        val fullName: String,
        val dateOfBirth: Date
)

fun PatientUpdateRequest.toEntity(id: Long) = Patient(
        id = id,
        fullName = fullName,
        dateOfBirth = dateOfBirth
)

data class PatientResponse(
        val id: Long,
        val fullName: String,
        val dateOfBirth: Date
)

fun Patient.toResponse() = PatientResponse(
        id = id,
        fullName = fullName,
        dateOfBirth = dateOfBirth
)
