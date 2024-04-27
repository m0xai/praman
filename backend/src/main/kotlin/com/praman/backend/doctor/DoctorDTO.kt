package com.praman.backend.doctor


data class DoctorCreateRequest(
    val fullName: String,
    val profession: String,
    val description: String,
)

fun DoctorCreateRequest.toEntity() = Doctor(
    fullName = fullName,
    profession = profession,
    description = description
)


data class DoctorUpdateRequest(
    val fullName: String,
    val profession: String,
    val description: String,
)

fun DoctorUpdateRequest.toEntity(id: Long) = Doctor(
    id = id,
    fullName = fullName,
    profession = profession,
    description = description,
)

data class DoctorResponse(
    val id: Long,
    val fullName: String,
    val profession: String,
    val description: String,
)

fun Doctor.toResponse() = DoctorResponse(
    id = id,
    fullName = fullName,
    profession = profession,
    description = description
)
