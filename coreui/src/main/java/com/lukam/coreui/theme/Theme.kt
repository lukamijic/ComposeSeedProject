package com.lukam.coreui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = Orange300,
    primaryVariant = Orange400,
    secondary = Orange300,
    secondaryVariant = Orange400,
    background = Gray100,
    surface = Color.White,
    error = Red900,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White
)

private val DarkThemeColors = darkColors(
    primary = Orange300,
    primaryVariant = Orange400,
    secondary = Orange300,
    secondaryVariant = Orange400,
    background = Gray900,
    surface = BlueGray900,
    error = Red900,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White
)

@Composable
fun ComposeSeedProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        shapes = ComposeSeedProjectShapes,
        content = content
    )
}
