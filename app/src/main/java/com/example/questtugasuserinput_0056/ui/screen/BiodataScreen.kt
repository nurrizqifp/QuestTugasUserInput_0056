package com.example.questtugasuserinput_0056.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.questtugasuserinput_0056.R
import com.example.questtugasuserinput_0056.ui.component.IndikatorHalaman

@Composable
fun BiodataScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = colorResource(R.color.transparan),
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Image(
                painter = painterResource(R.drawable.bg_neon),
                contentDescription = stringResource(R.string.cd_gambar_latar),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
            IndikatorHalaman(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(dimensionResource(R.dimen.spasi_16)),
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(dimensionResource(R.dimen.jarak_kartu_ke_tepi))
                    .fillMaxWidth()
                    .shadow(
                        dimensionResource(R.dimen.elevasi_kartu),
                        RoundedCornerShape(dimensionResource(R.dimen.radius_kartu)),
                    )
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.radius_kartu)))
                    .background(colorResource(R.color.putih_kartu))
                    .verticalScroll(rememberScrollState())
                    .padding(dimensionResource(R.dimen.spasi_16)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spasi_12)),
            ) {
                Text(
                    text = stringResource(R.string.judul_form),
                    color = colorResource(R.color.ungu_judul),
                    fontSize = dimensionResource(R.dimen.ukuran_teks_judul).value.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
                Text(
                    text = stringResource(R.string.subjudul_form),
                    color = colorResource(R.color.abu_subjudul),
                    fontSize = dimensionResource(R.dimen.ukuran_teks_subjudul).value.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}
