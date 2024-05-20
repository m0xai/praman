package com.praman.backend.user

import java.beans.ConstructorProperties

data class LoginDTO
@ConstructorProperties("email", "password")
constructor(val email: String, val password: String)

data class LoginResponse(val token: String)
