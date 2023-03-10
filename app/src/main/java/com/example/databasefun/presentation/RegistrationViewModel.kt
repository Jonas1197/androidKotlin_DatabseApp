package com.example.databasefun.presentation

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databasefun.cache.CacheUserData
import com.example.databasefun.cache.UserDataDatabase
import com.example.databasefun.domain.usecases.InsertUserDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class RegistrationViewModel(
    application: Application
): ViewModel() {

    var state by mutableStateOf(RegistrationState())
        private set

    val database = UserDataDatabase.getInstance(application)

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

    fun updateShowsAlert(showsAlert: Boolean) {
        state = state.copy(
            showsAlert = showsAlert
        )
    }

    private fun containsFullDetails() = (state.firstName.isNotEmpty() && state.lastName.isNotEmpty()
            && state.fullAddress.isNotEmpty() && state.serialNumber.isNotEmpty())


    fun registrationDetails(): String {
        return "Full name: ${state.firstName} ${state.lastName}\n" +
                "Address: ${state.fullAddress}\n" +
                "Serial number: ${state.serialNumber}"
    }

    fun canRegister(): Boolean = containsFullDetails()

    fun updateData(showsAlert: Boolean? = null) {
        state = state.copy(
            showsAlert = showsAlert ?: containsFullDetails()
        )

        if(containsFullDetails()) {
            val useCase = InsertUserDataUseCase(database)
            (viewModelScope + Dispatchers.IO).launch {
                useCase.invoke(
                    CacheUserData(
                        firstName = state.firstName,
                        lastName = state.lastName,
                        fullAddress = state.fullAddress,
                        serialNumber = state.serialNumber
                    )
                )
            }
        }

        // Get users by name
//        viewModelScope.launch {
//            val users = FindUserByFirstNameUseCase(database)
//                .invoke("Name")
//
//            users.collectLatest {
//                it.last()
//            }
//        }

    }
}