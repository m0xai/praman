package com.praman.backend.patient

import com.praman.backend.base.BaseEntity
import jakarta.persistence.Entity
import java.util.*

@Entity(name = "patients")
data class Patient(
    val fullName: String,
    val dateOfBirth: Date
) : BaseEntity() {
    constructor(id: Long, fullName: String, dateOfBirth: Date) : this(fullName, dateOfBirth) {
        this.id = id
    }
}
