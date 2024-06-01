package com.praman.backend.user

import com.praman.backend.doctor.DoctorService
import com.praman.backend.patient.PatientService
import com.praman.backend.patient.exceptions.ResourceNotFoundException
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*


@Service
class AppUserService(
    private val repository: AppUserRepository,
    private val doctorService: DoctorService,
    private val patientService: PatientService
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

    fun getByEmail(email: String): Any {
        val oUser = repository.findByEmail(email);
        if (oUser.isEmpty) {
            throw ResourceNotFoundException("User with the email: ${email} not found")
        }
        val user = oUser.get();
        if (user.role == "ROLE_DOCTOR") {
            val doctor = doctorService.getByEmail(user.email)
            return DoctorUser(user.id, user.email, user.username, user.role, doctor)
        } else if (user.role == "ROLE_PATIENT") {
            val patient = patientService.getByEmail(user.email)
            return PatientUser(user.id, user.email, user.username, user.role, patient)
        }
        throw ResourceNotFoundException("User with the email: ${user.email} not found")
    }
}
