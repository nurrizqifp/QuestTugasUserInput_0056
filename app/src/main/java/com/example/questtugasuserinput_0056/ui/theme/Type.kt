package com.example.questtugasuserinput_0056.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.sp
import com.example.questtugasuserinput_0056.R

@Composable
fun typographyFromResources(): Typography {
    val bodySize = dimensionResource(R.dimen.ukuran_teks_isi).value.sp
    return Typography(
        bodyLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = bodySize,
            lineHeight = bodySize,
        ),
    )
}