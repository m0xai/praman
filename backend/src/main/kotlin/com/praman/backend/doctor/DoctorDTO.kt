package com.praman.backend.doctor


data class DoctorCreateRequest(
    val email: String,
    val fullName: String,
    val profession: String,
    val description: String,
)

fun DoctorCreateRequest.toEntity() = Doctor(
    email = email,
    fullName = fullName,
    profession = profession,
    description = description
)


data class DoctorUpdateRequest(
    val email: String,
    val fullName: String,
    val profession: String,
    val description: String,
)

fun DoctorUpdateRequest.toEntity(id: Long) = Doctor(
    id = id,
    email = email,
    fullName = fullName,
    profession = profession,
    description = description,
)

data class DoctorResponse(
    val id: Long,
    val email: String,
    val fullName: String,
    val profession: String,
    val description: String,
)

fun Doctor.toResponse() = DoctorResponse(
    id = id,
    email = email,
    fullName = fullName,
    profession = profession,
    description = description
)
