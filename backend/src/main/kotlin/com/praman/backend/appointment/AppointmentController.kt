package com.praman.backend.appointment

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("api/appointments")
class AppointmentController(val service: AppointmentService) {
    @GetMapping
    fun list(): ResponseEntity<List<AppointmentResponse>> {
        try {
            return ResponseEntity.ok().body(service.list())
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    @GetMapping("{id}")
    fun get(@PathVariable id: Long): ResponseEntity<AppointmentResponse> {
        try {
            return ResponseEntity.ok().body(service.get(id))
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    @PostMapping
    fun create(@RequestBody request: AppointmentCreateRequest): ResponseEntity<AppointmentResponse> {
        try {
            return ResponseEntity.ok().body(service.create(request));
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    @PatchMapping("{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: AppointmentUpdateRequest
    ): ResponseEntity<AppointmentResponse> {
        try {
            return ResponseEntity.ok().body(service.update(id, request))
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        try {
            service.delete(id);
            return ResponseEntity.ok().build()
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }
}
