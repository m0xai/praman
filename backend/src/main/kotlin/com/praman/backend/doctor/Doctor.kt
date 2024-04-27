package com.praman.backend.doctor

import com.praman.backend.base.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity(name = "doctors")
data class Doctor(
    val fullName: String,
    val profession: String,
    @Column(columnDefinition = "TEXT")
    val description: String,
) : BaseEntity() {
    constructor(id: Long, fullName: String, profession: String, description: String) : this(
        fullName, profession, description
    ) {
        this.id = id;
    }
}
