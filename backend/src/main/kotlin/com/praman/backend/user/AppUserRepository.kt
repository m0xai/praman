package com.praman.backend.user

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AppUserRepository : JpaRepository<AppUser, Long> {
    fun findByEmail(email: String): Optional<AppUser>;
}
