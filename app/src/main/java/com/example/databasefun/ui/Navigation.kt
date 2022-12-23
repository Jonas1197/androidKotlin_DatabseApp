package com.example.databasefun.ui

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
            LicencePresentationScreen(
                application = applicationContext as Application,
                navController = navController
            )
        }
    }
}