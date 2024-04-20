package com.praman.backend.patient

import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.stereotype.Service

@Service
class PatientService(val repository: PatientRepository) {
    fun list(): List<Patient> {
        return repository.findAll()
    }

    fun get(id: Long): Patient {
        val patient = repository.findById(id);
        if (patient.isPresent) {
            return patient.get()
        } else {
            throw ResourceNotFoundException("Patient with ID: $id not found.")
        }
    }

    fun create(request: PatientCreateRequest): Patient {
        return repository.save(request.toEntity())
    }
}
