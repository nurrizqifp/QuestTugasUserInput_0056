package com.example.questtugasuserinput_0056.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.questtugasuserinput_0056.R

@Composable
fun IndikatorHalaman(modifier: Modifier = Modifier) {
    val jumlahIndikator = integerResource(R.integer.jumlah_indikator)
    val indikatorAktif = integerResource(R.integer.indikator_aktif)
    val ukuranAktif = dimensionResource(R.dimen.ukuran_titik_aktif)
    val ukuranTidakAktif = dimensionResource(R.dimen.ukuran_titik)
    val warnaAktif = colorResource(R.color.biru_indikator_aktif)
    val warnaTidakAktif = colorResource(R.color.abu_indikator)

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spasi_8)),
    ) {
        repeat(jumlahIndikator) { indeks ->
            val aktif = indeks == indikatorAktif
            Box(
                modifier = Modifier
                    .size(if (aktif) ukuranAktif else ukuranTidakAktif)
                    .background(if (aktif) warnaAktif else warnaTidakAktif, CircleShape),
            )
        }
    }
}

@Composable
fun FieldTeks(
    nilai: String,
    onNilaiBerubah: (String) -> Unit,
    @StringRes label: Int,
    modifier: Modifier = Modifier,
    tipeKeyboard: KeyboardType = KeyboardType.Text,
) {
    OutlinedTextField(
        value = nilai,
        onValueChange = onNilaiBerubah,
        label = { Text(stringResource(label)) },
        singleLine = true,
        maxLines = integerResource(R.integer.maks_baris),
        shape = RoundedCornerShape(dimensionResource(R.dimen.radius_field)),
        keyboardOptions = KeyboardOptions(keyboardType = tipeKeyboard),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(R.color.ungu_tombol),
            unfocusedBorderColor = colorResource(R.color.abu_garis_field),
        ),
        modifier = modifier,
    )
}
