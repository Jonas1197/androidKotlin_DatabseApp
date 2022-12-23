package com.example.databasefun.ui

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.databasefun.cache.UserDataDao
import com.example.databasefun.cache.UserDataDatabase
import com.example.databasefun.data.UserDataRepository
import com.example.databasefun.domain.usecases.GetSavedUserDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.invoke

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val applicationContext = LocalContext.current.applicationContext
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route
    ) {

        composable(route = Screen.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }

        composable(route = Screen.RegistrationScreen.route) {
            RegistrationScreen(
                application = applicationContext as Application,
                navController = navController
            )
        }

        composable(Screen.LicencePresentationScreen.route) {
            UserDataDatabase.getInstance(
                applicationContext as Application
            )

            LicencePresentationScreen(
                application = applicationContext as Application,
                navController = navController
            )

        }
    }
}