package com.praman.backend.patient

import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("patients")
@CrossOrigin(origins = ["http://localhost:4200"])
class PatientController(val service: PatientService) {
    @GetMapping("/")
    fun list(): ResponseEntity<List<Patient>> {
        return ResponseEntity.ok().body(service.list())
    }

    @GetMapping("/{id}/")
    fun get(@PathVariable id: Long): ResponseEntity<Patient> {
        try {
            return ResponseEntity.ok().body(service.get(id))
        } catch (ex: ResourceNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Patient with ID: $id not found")
        }
    }

    @PostMapping("/")
    fun create(@RequestBody request: PatientCreateRequest): ResponseEntity<PatientResponse> {
        val patient = service.create(request)
        return ResponseEntity.ok().body(patient.toResponse())
    }

}
