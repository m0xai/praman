package com.praman.backend.doctor

import com.praman.backend.patient.exceptions.ResourceNotFoundException
import org.springframework.stereotype.Service

@Service
class DoctorService(val repository: DoctorRepository) {
    fun getEntityById(id: Long): Doctor {
        if (repository.existsById(id)) {
            return repository.findById(id).get()
        }
        throw ResourceNotFoundException("Doctor with $id not found")
    }

    fun list(): List<DoctorResponse> {
        return repository.findAll().map { it.toResponse() };
    }

    fun get(id: Long): DoctorResponse {
        if (repository.existsById(id)) {
            val entity = repository.findById(id);
            return entity.get().toResponse()
        }
        throw ResourceNotFoundException("Doctor with $id not found")
    }

    fun create(doctor: DoctorCreateRequest): DoctorResponse {
        val entity = repository.save(doctor.toEntity());
        return entity.toResponse();
    }

    fun update(id: Long, request: DoctorUpdateRequest): DoctorResponse {
        if (!repository.existsById(id)) {
            throw ResourceNotFoundException("Doctor with $id not found")
        }
        return repository.save(request.toEntity(id)).toResponse()
    }

    fun delete(id: Long) {
        if (!repository.existsById(id)) {
            throw ResourceNotFoundException("Doctor with $id not found")
        }
        repository.deleteById(id);
    }
}
