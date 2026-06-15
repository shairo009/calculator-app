package com.example.calculator

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFF9F0A),
    surface = Color(0xFF1E1E1E),
    background = Color(0xFF121212),
    onPrimary = Color.White,
    onSurface = Color.White,
    onBackground = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFF9F0A),
    surface = Color.White,
    background = Color(0xFFF5F5F5),
    onPrimary = Color.White,
    onSurface = Color.Black,
    onBackground = Color.Black
)

@Composable
fun CalculatorTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        content = content
    )
}