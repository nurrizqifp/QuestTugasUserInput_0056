package com.example.questtugasuserinput_0056.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.questtugasuserinput_0056.R

@Composable
fun QuestTugasUserInput_0056Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val primary = colorResource(R.color.ungu_tombol)
    val secondary = colorResource(R.color.ungu_judul)
    val tertiary = colorResource(R.color.biru_indikator_aktif)
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = primary,
            secondary = secondary,
            tertiary = tertiary,
        )
    } else {
        lightColorScheme(
            primary = primary,
            secondary = secondary,
            tertiary = tertiary,
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typographyFromResources(),
        content = content
    )
}