package com.praman.backend.patient

import com.praman.backend.patient.enums.BloodGroup
import java.time.LocalDateTime
import java.util.*

data class PatientCreateRequest(
    val fullName: String,
    val dateOfBirth: Date,
    val phoneNumber: String,
    val bloodGroup: BloodGroup,
)

fun PatientCreateRequest.toEntity() = Patient(
    fullName = fullName,
    dateOfBirth = dateOfBirth,
    phoneNumber = phoneNumber,
    bloodGroup = bloodGroup
)

data class PatientUpdateRequest(
    val fullName: String,
    val dateOfBirth: Date,
    val phoneNumber: String,
    val bloodGroup: BloodGroup,
)

fun PatientUpdateRequest.toEntity(id: Long) = Patient(
    id = id,
    fullName = fullName,
    dateOfBirth = dateOfBirth,
    phoneNumber = phoneNumber,
    bloodGroup = bloodGroup
)

data class PatientResponse(
    val id: Long,
    val fullName: String,
    val dateOfBirth: Date,
    val phoneNumber: String,
    val bloodGroup: BloodGroup,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)

fun Patient.toResponse() = PatientResponse(
    id = id,
    fullName = fullName,
    dateOfBirth = dateOfBirth,
    phoneNumber = phoneNumber,
    bloodGroup = bloodGroup,
    createdAt = createdAt,
    updatedAt = updatedAt
)
