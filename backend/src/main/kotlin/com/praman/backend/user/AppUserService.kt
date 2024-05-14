package com.praman.backend.user

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*


@Service
class AppUserService(
    private val repository: AppUserRepository,
) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        // Create a method in your repo to find a user by its username
        val user = repository.findByEmail(email)
        if (user.isPresent) {
            val u = user.get()
            return AppUserDetails(
                u.id,
                u.email,
                u.password,
                Collections.singleton(SimpleGrantedAuthority("ROLE_" + u.role))
            )
        }
        return AppUserDetails(
            0,
            "",
            "",
            Collections.singleton(SimpleGrantedAuthority("user"))
        )
    }
}
