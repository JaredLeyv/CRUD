package com.example.crud.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

// Definir colores para el tema oscuro y claro
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF6200EE), // Color vibrante para el botón principal
    secondary = Color(0xFF03DAC6), // Color verde claro para acciones secundarias
    tertiary = Color(0xFFBB86FC), // Color suave para elementos secundarios
    background = Color(0xFF121212), // Fondo oscuro
    surface = Color(0xFF121212), // Superficie oscura
    onPrimary = Color.White, // Texto blanco sobre botones
    onSecondary = Color.Black, // Texto negro sobre elementos secundarios
    onBackground = Color.White, // Texto blanco sobre el fondo
    onSurface = Color.White // Texto blanco sobre superficies
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE), // Color vibrante para el botón principal
    secondary = Color(0xFF03DAC6), // Color verde claro para acciones secundarias
    tertiary = Color(0xFFBB86FC), // Color suave para elementos secundarios
    background = Color(0xFFF5F5F5), // Fondo claro
    surface = Color(0xFFFFFFFF), // Superficie blanca
    onPrimary = Color.White, // Texto blanco sobre botones
    onSecondary = Color.Black, // Texto negro sobre elementos secundarios
    onBackground = Color.Black, // Texto negro sobre el fondo
    onSurface = Color.Black // Texto negro sobre superficies
)

@Composable
fun CrudTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Soporte para colores dinámicos en Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // Seleccionar el esquema de colores según el modo de tema y soporte dinámico
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Aplicar el tema con los esquemas de colores y tipografía
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Usar la tipografía predeterminada o personalizada
        content = content
    )
}