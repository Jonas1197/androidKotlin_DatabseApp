package com.example.databasefun.presentation

data class RegistrationState(

    val firstName: String = "",
    val lastName: String = "",
    val fullAddress: String = "",
    val serialNumber: String = "",

    val showsAlerts: Boolean = false

)