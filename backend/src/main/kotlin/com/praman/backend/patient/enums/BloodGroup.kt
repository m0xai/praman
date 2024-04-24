package com.praman.backend.patient.enums

enum class BloodGroup(val group: String) {
    APOSITIVE("A+"),
    ANEGATIVE("A-"),
    ABPOSITIVE("AB+"),
    ABNEGATIVE("AB-"),
    BNEGATIVE("B-"),
    BPOSITIVE("B+"),
    NOTSET(""),
    ONEGATIVE("O-"),
    OPOSITIVE("O+")
}
