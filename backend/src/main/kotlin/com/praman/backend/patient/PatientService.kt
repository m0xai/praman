package com.praman.backend.patient

import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.stereotype.Service

@Service
class PatientService(val repository: PatientRepository) {
    fun list(): List<Patient> {
        return repository.findAll()
    }

    fun get(id: Long): Patient {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
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
