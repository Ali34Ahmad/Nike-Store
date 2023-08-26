package com.example.composeplayground.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    object SignUpScreen:Screen()
    object TermsAndConditionsScreen:Screen()
}

object PostOfficeAppRouter{
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigationTo(destination:Screen){
        currentScreen.value=destination
    }
}
