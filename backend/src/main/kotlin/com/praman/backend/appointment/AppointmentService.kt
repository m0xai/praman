package com.praman.backend.appointment

import com.praman.backend.doctor.DoctorService
import com.praman.backend.patient.PatientService
import com.praman.backend.patient.exceptions.ResourceNotFoundException
import com.praman.backend.user.UserUtil
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AppointmentService(
    val repository: AppointmentRepository,
    val patientService: PatientService,
    val doctorService: DoctorService
) {
    private final val logger = LoggerFactory.getLogger(AppointmentService::class.java)

    fun list(): List<AppointmentResponse> {
        val isPatient = UserUtil.hasRole("PATIENT");
        val isDoctor = UserUtil.hasRole("DOCTOR");

        val userEmail = UserUtil.email();

        val appointmentList = if (isPatient) {
            repository.findAllByPatientEmail(userEmail);
        } else if (isDoctor) {
            repository.findAllByDoctorEmail(userEmail)
        } else {
            repository.findAll()
        }
        return appointmentList.map { ap ->
            ap.toResponse(ap.patient, ap.doctor)
        }
    }

    fun get(id: Long): AppointmentResponse {
        if (repository.existsById(id)) {
            val appointment = repository.findById(id).get()
            return appointment.toResponse(appointment.patient, appointment.doctor)
        }
        throw ResourceNotFoundException("Appointment with ID: $id not found")
    }

    fun create(request: AppointmentCreateRequest): AppointmentResponse {
        val patient = patientService.getEntityById(request.patientId)
        val doctor = doctorService.getEntityById(request.doctorId)
        val appointment = repository.save(request.toEntity(patient, doctor))
        return appointment.toResponse(patient, doctor)
    }

    fun update(id: Long, request: AppointmentUpdateRequest): AppointmentResponse {
        try {
            val patient = patientService.getEntityById(request.patientId)
            val doctor = doctorService.getEntityById(request.doctorId)
            val appointment = repository.save(request.toEntity(id = id, patient = patient, doctor = doctor))
            return appointment.toResponse(patient, doctor)
        } catch (ex: Exception) {
            throw ResourceNotFoundException(ex.message)
        }
    }

    fun delete(id: Long) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw ResourceNotFoundException("Appointment with ID: $id not found")
        }
    }
}
