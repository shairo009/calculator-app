package com.example.calculator

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF57868C),
    secondary = Color(0xFF252932),
    tertiary = Color(0xFF3A7A82),
    background = Color(0xFF141414),
    surface = Color(0xFF1E1E1E),
    surfaceVariant = Color(0xFF252932),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onSurfaceVariant = Color(0xFFB0B0B0)
)

// Calculator specific colors
object CalcColors {
    val background = Color(0xFF141414)
    val displayBg = Color(0xFF141414)
    val numberBtn = Color(0xFF2A2D35)
    val numberBtnPressed = Color(0xFF3A3D45)
    val operatorBtn = Color(0xFF57868C)
    val operatorBtnPressed = Color(0xFF6A9BA1)
    val functionBtn = Color(0xFF3D4049)
    val functionBtnPressed = Color(0xFF4D5059)
    val textWhite = Color(0xFFFFFFFF)
    val textGray = Color(0xFFB0B0B0)
}

@Composable
fun CalculatorTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}
