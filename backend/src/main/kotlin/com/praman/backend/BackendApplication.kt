package com.praman.backend

import com.praman.backend.user.AppUser
import com.praman.backend.user.AppUserRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}


@Component
class PraManInit(
    private val repo: AppUserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) {
    init {
        createUser()
    }

    fun createUser() {
        val u = repo.findByEmail("kerem@z.de")
        if (!u.isPresent)
            repo.save(
                AppUser(
                    1, "kerem", password = passwordEncoder.encode("1299"), email = "kerem@z.de", role =
                    "ADMIN"
                ),
            )
        repo.save(
            AppUser(2, "patient", password = passwordEncoder.encode("1299"), email = "pat@ie.nt", "PATIENT")
        )
        repo.save(
            AppUser(3, "doctor", password = passwordEncoder.encode("1299"), email = "do@ct.or", "DOCTOR")
        )
    }
}
