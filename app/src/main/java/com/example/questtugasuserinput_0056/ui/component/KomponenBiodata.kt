package com.example.questtugasuserinput_0056.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
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
