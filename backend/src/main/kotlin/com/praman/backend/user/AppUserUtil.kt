package com.praman.backend.user

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder


object UserUtil {
    fun email(): String {
        val authentication: AppUserDetails =
            SecurityContextHolder.getContext().authentication.principal as AppUserDetails
        return authentication.email
    }

    fun hasRole(roleName: String): Boolean {
        return SecurityContextHolder.getContext().authentication.authorities.stream()
            .anyMatch { grantedAuthority: GrantedAuthority? -> grantedAuthority!!.authority == roleName }
    }
}
