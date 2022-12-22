package com.example.databasefun

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcome_screen")
    object RegistrationScreen : Screen("registration_screen")
}
