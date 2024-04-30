package com.praman.backend.doctor

import com.praman.backend.patient.exceptions.ResourceNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/doctors")
class DoctorController(private val service: DoctorService) {

    @GetMapping
    fun list(): ResponseEntity<List<DoctorResponse>> {
        return ResponseEntity.ok().body(service.list());
    }

    @GetMapping("{id}")
    fun get(@PathVariable id: Long): ResponseEntity<DoctorResponse> {
        try {
            return ResponseEntity.ok().body(service.get(id));
        } catch (ex: ResourceNotFoundException) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    fun create(@RequestBody request: DoctorCreateRequest): ResponseEntity<DoctorResponse> {
        return ResponseEntity.ok().body(service.create(request))
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody request: DoctorUpdateRequest): ResponseEntity<DoctorResponse> {
        try {
            return ResponseEntity.ok().body(service.update(id, request))
        } catch (ex: ResourceNotFoundException) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        try {
            service.delete(id)
            return ResponseEntity.ok().build()
        } catch (ex: ResourceNotFoundException) {
            return ResponseEntity.notFound().build();
        }
    }
}
