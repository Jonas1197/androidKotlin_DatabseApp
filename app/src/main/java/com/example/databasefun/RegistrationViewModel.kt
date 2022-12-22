package com.example.databasefun

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegistrationViewModel: ViewModel() {

    var state by mutableStateOf(RegistrationState())
        private set

    fun updateFirstName(firstName: String) {
        state = state.copy(
            firstName = firstName
        )
    }

    fun updateLastName(lastName: String) {
        state = state.copy(
            lastName = lastName
        )
    }

    fun updateFullAddress(fullAddress: String) {
        state = state.copy(
            fullAddress = fullAddress
        )
    }

    fun updateSerialNumber(serialNumber: String) {
        state = state.copy(
            serialNumber = serialNumber
        )
    }

    fun containsFullDetails(): Boolean {
        return !(
                state.firstName.isNullOrEmpty() ||
                        state.lastName.isNullOrEmpty() ||
                        state.fullAddress.isNullOrEmpty() ||
                        state.serialNumber.isNullOrEmpty()
                )
    }

    fun registrationDetails(): String {
        return "Full name: ${state.firstName} ${state.lastName}\n" +
                "Address: ${state.fullAddress}\n" +
                "Serial number: ${state.serialNumber}"
    }
}