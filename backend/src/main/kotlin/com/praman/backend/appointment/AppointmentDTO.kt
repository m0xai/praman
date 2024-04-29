package com.praman.backend.appointment

import com.praman.backend.doctor.Doctor
import com.praman.backend.patient.Patient
import java.time.LocalDate
import java.time.LocalTime

class AppointmentCreateRequest(
    val patientId: Long,
    val doctorId: Long,
    val date: LocalDate,
    val time: LocalTime,
    val reason: String,
    val status: AppointmentStatus,
) {}

fun AppointmentCreateRequest.toEntity(patient: Patient, doctor: Doctor) = Appointment(
    patient = patient,
    doctor = doctor,
    date = this.date,
    time = this.time,
    reason = this.reason,
    status = this.status
)

class AppointmentUpdateRequest(
    val patientId: Long,
    val doctorId: Long,
    val date: LocalDate,
    val time: LocalTime,
    val reason: String,
    val status: AppointmentStatus,
)

fun AppointmentUpdateRequest.toEntity(id: Long, patient: Patient, doctor: Doctor) = Appointment(
    id = id,
    patient = patient,
    doctor = doctor,
    date = this.date,
    time = this.time,
    reason = this.reason,
    status = this.status
)

class AppointmentResponse(
    val id: Long,
    val patient: Patient,
    val doctor: Doctor,
    val date: LocalDate,
    val time: LocalTime,
    val reason: String,
    val status: AppointmentStatus,
)

fun Appointment.toResponse(patient: Patient, doctor: Doctor) = AppointmentResponse(
    id, patient, doctor, date, time, reason, status
)
