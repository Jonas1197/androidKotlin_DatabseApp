package com.example.databasefun.presentation

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databasefun.cache.UserDataDatabase
import com.example.databasefun.domain.usecases.GetSavedUserDataUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.job
import kotlinx.coroutines.launch

class LicencePresentationViewModel(
    application: Application
): ViewModel() {
    var state by mutableStateOf(LicensePresentationState())
        private set

    var database = UserDataDatabase.getInstance(application)

    fun fetchUpdatedData() {

        print("\n\n~~> Fetching data...\n\n")

        viewModelScope.launch {
            GetSavedUserDataUseCase(database)
                .invoke()
                .collect {
                    val lastSavedUser = it.last()
                    print("\n~~> User: ${lastSavedUser.serialNumber}\n\n\n")

                    state = state.copy(
                        userData = lastSavedUser,
                        formattedData = "Full name: ${lastSavedUser.firstName + " " + lastSavedUser.lastName }" +
                                "Address: ${lastSavedUser.fullAddress}" +
                                "Serial number: ${lastSavedUser.serialNumber}"
                    )
                }
        }
    }
}