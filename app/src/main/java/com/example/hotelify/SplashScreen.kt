package com.example.hotelify

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigate: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6EEEE)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Replace with your logo
            contentDescription = "App Logo",
            modifier = Modifier.size(350.dp)
        )
    }
    LaunchedEffect(true) {
        delay(2000) // Splash duration (2 seconds)
        onNavigate() // Trigger the transition to Login Screen
    }
}



@Composable
fun SplashToLoginScreen() {
    var currentScreen by remember { mutableStateOf(Screens.Splash) }

    // Crossfade transition between screens
    Crossfade(targetState = currentScreen, animationSpec = tween(durationMillis = 1000),
        label = "SplashToLogin"
    ) {
            screen ->
        when (screen) {
            Screens.Splash -> SplashScreen(onNavigate = {
                currentScreen = Screens.Login // Transition to Login screen after splash duration
            })
            Screens.Login -> LoginScreen() // Display login screen after transition
        }
    }
}

enum class Screens {
    Splash,
    Login
}

