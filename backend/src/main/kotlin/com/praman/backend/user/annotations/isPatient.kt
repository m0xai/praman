package com.praman.backend.user.annotations

import org.springframework.security.access.prepost.PreAuthorize

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@PreAuthorize("hasRole('PATIENT')")
annotation class isPatient
