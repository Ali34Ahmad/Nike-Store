package com.example.composeplayground.ui.navigation

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.staticCompositionLocalOf

val localBackPressedDispatcher =
    staticCompositionLocalOf<OnBackPressedDispatcherOwner?> { null }

private class BackNavigationHandler(enable:Boolean):OnBackPressedCallback(enable){
    lateinit var onBackPressed:()->Unit
    override fun handleOnBackPressed() {
        onBackPressed()
    }

}