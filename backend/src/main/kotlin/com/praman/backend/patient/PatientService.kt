package com.praman.backend.patient

import com.praman.backend.patient.exceptions.ResourceNotFoundException
import org.springframework.stereotype.Service

@Service
class PatientService(val repository: PatientRepository) {
    fun getEntityById(id: Long): Patient {
        if (repository.existsById(id)) {
            return repository.findById(id).get()
        }
        throw ResourceNotFoundException("Patient with ID: $id not found.")
    }

    fun list(): List<PatientResponse> {
        return repository.findAll().map { it.toResponse() }
    }

    fun get(id: Long): PatientResponse {
        if (repository.existsById(id)) {
            return repository.findById(id).get().toResponse()
        } else {
            throw ResourceNotFoundException("Patient with ID: $id not found.")
        }
    }

    fun create(request: PatientCreateRequest): Patient {
        return repository.save(request.toEntity())
    }

    fun update(id: Long, request: PatientUpdateRequest): Patient {
        if (repository.existsById(id)) {
            return repository.save(request.toEntity(id))
        } else {
            throw ResourceNotFoundException("Patient with ID: $id not found.")
        }
    }

    fun delete(id: Long) {
        if (repository.existsById(id)) {
            return repository.deleteById(id)
        } else {
            throw ResourceNotFoundException("Patient with ID: $id not found.")
        }
    }
}
