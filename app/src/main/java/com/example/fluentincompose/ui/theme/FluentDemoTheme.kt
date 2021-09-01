package com.example.fluentincompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun FluentDemoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        remember { darkColors() }
    } else {
        remember { lightColors() }
    }

    FluentTheme(
        colors = colors,
        content = content
    )
}

