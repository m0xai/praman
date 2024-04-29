package com.praman.backend.appointment

import com.praman.backend.base.BaseEntity
import com.praman.backend.doctor.Doctor
import com.praman.backend.patient.Patient
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity(name = "appointments")
data class Appointment(
    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.REMOVE]
    )
    @JoinColumn(name = "patient_id")
    val patient: Patient,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    val doctor: Doctor,

    val date: LocalDate,
    val time: LocalTime,
    val reason: String,
    val status: AppointmentStatus
) : BaseEntity() {
    constructor(
        id: Long, patient: Patient, doctor: Doctor, date: LocalDate, time: LocalTime, reason: String, status:
        AppointmentStatus
    ) : this(
        patient, doctor, date, time, reason, status
    ) {
        this.id = id
    }
}
