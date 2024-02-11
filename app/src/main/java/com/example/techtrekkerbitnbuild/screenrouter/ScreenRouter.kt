package com.example.techtrekkerbitnbuild.screenrouter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {

    data object SignUpScreen : Screen()
    data object LoginScreen : Screen()

    data object HomeScreen : Screen()

    data object ProfileScreen : Screen()

    data object EditProfileScreen : Screen()

}

object ScreenRouter {
    val currentScreen: MutableState<Screen> = mutableStateOf(Screen.HomeScreen)


    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }
}

