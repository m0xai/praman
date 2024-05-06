package com.praman.backend.user

import com.praman.backend.base.BaseEntity
import jakarta.persistence.Entity

@Entity
class AppUser(
    val username: String,
    val password: String,
    val email: String,
    val role: String
) : BaseEntity() {
    constructor(id: Long, username: String, password: String, email: String, role: String) : this(
        username,
        password,
        email,
        role
    ) {
        this.id = id
    }
}
