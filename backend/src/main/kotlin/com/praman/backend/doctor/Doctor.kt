package com.praman.backend.doctor

import com.praman.backend.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity(name = "doctors")
data class Doctor(
    @Column(unique = true, nullable = false)
    val email: String,
    val fullName: String,
    val profession: String,
    @Column(columnDefinition = "TEXT")
    val description: String,
) : BaseEntity() {
    constructor(id: Long, email: String, fullName: String, profession: String, description: String) : this(
        email, fullName, profession, description
    ) {
        this.id = id;
    }
}
