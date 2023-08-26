package com.example.composeplayground.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.ui.screens.auth.SignUpScreen
import com.example.composeplayground.ui.theme.ComposePlayGroundTheme

@Composable
fun ComposePlayGroundApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(28.dp),
        color = Color.White,


        ) {
        Crossfade(targetState = PostOfficeAppRouter.currentScreen) {currentState->
            when(currentState.value){
                is Screen.SignUpScreen-> SignUpScreen()
                is Screen.TermsAndConditionsScreen-> TermsAndConditionsScreen()
            }
            
        }
    }
}