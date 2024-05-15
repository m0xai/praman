package com.praman.backend.patient

import com.praman.backend.base.BaseEntity
import com.praman.backend.patient.enums.BloodGroup
import jakarta.persistence.Column
import jakarta.persistence.Entity
import java.util.*

@Entity(name = "patients")
data class Patient(
    @Column(unique = true, nullable = false)
    val email: String,
    val fullName: String,
    val dateOfBirth: Date,
    val phoneNumber: String,
    val bloodGroup: BloodGroup,
) : BaseEntity() {
    constructor(
        id: Long, email: String, fullName: String, dateOfBirth: Date, phoneNumber: String, bloodGroup:
        BloodGroup
    ) : this(
        email,
        fullName,
        dateOfBirth,
        phoneNumber,
        bloodGroup
    ) {
        this.id = id
    }
}
