package com.example.questtugasuserinput_0056.ui.component

import android.app.DatePickerDialog
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.questtugasuserinput_0056.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

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

@Composable
fun FieldTanggal(
    nilai: String,
    onTanggalBerubah: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val zonaWaktu = stringResource(R.string.zona_waktu)
    val kalender = Calendar.getInstance(TimeZone.getTimeZone(zonaWaktu), Locale.getDefault())
    val pemilihTanggal = {
        DatePickerDialog(
            context,
            { _, tahun, bulan, hari ->
                kalender.set(tahun, bulan, hari)
                val formatter = SimpleDateFormat(
                    context.getString(R.string.format_tanggal),
                    Locale.getDefault(),
                ).apply {
                    timeZone = TimeZone.getTimeZone(zonaWaktu)
                }
                onTanggalBerubah(formatter.format(kalender.time))
            },
            kalender.get(Calendar.YEAR),
            kalender.get(Calendar.MONTH),
            kalender.get(Calendar.DAY_OF_MONTH),
        ).show()
    }

    OutlinedTextField(
        value = nilai,
        onValueChange = {},
        readOnly = true,
        singleLine = true,
        maxLines = integerResource(R.integer.maks_baris),
        label = { Text(stringResource(R.string.label_tanggal_lahir)) },
        trailingIcon = {
            IconButton(onClick = pemilihTanggal) {
                Icon(
                    painter = painterResource(R.drawable.ic_kalender),
                    contentDescription = stringResource(R.string.cd_ikon_kalender),
                )
            }
        },
        shape = RoundedCornerShape(dimensionResource(R.dimen.radius_field)),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(R.color.ungu_tombol),
            unfocusedBorderColor = colorResource(R.color.abu_garis_field),
        ),
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldDropdown(
    nilai: String,
    pilihan: List<String>,
    onPilihanBerubah: (Int) -> Unit,
    @StringRes label: Int,
    modifier: Modifier = Modifier,
) {
    val terbuka = remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = terbuka.value,
        onExpandedChange = { terbuka.value = !terbuka.value },
        modifier = modifier,
    ) {
        OutlinedTextField(
            value = nilai,
            onValueChange = {},
            readOnly = true,
            singleLine = true,
            maxLines = integerResource(R.integer.maks_baris),
            label = { Text(stringResource(label)) },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_panah_bawah),
                    contentDescription = stringResource(R.string.cd_ikon_panah_bawah),
                )
            },
            shape = RoundedCornerShape(dimensionResource(R.dimen.radius_field)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.ungu_tombol),
                unfocusedBorderColor = colorResource(R.color.abu_garis_field),
            ),
            modifier = Modifier
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                .fillMaxWidth(),
        )
        ExposedDropdownMenu(
            expanded = terbuka.value,
            onDismissRequest = { terbuka.value = false },
        ) {
            pilihan.forEachIndexed { indeks, teksPilihan ->
                DropdownMenuItem(
                    text = { Text(teksPilihan) },
                    onClick = {
                        onPilihanBerubah(indeks)
                        terbuka.value = false
                    },
                )
            }
        }
    }
}

@Composable
fun BarisSkill(
    pilihan: List<String>,
    terpilih: Set<Int>,
    onSkillBerubah: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        pilihan.forEachIndexed { indeks, namaSkill ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = indeks in terpilih,
                    onCheckedChange = { onSkillBerubah(indeks) },
                )
                Text(
                    text = namaSkill,
                    color = colorResource(R.color.hitam_teks),
                    fontSize = dimensionResource(R.dimen.ukuran_teks_skill).value.sp,
                )
            }
        }
    }
}

@Composable
fun TombolProses(
    aktif: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        enabled = aktif,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.ungu_tombol),
            contentColor = colorResource(R.color.putih_kartu),
            disabledContainerColor = colorResource(R.color.abu_tombol_nonaktif),
            disabledContentColor = colorResource(R.color.putih_teks_nonaktif),
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.tinggi_tombol)),
    ) {
        Text(stringResource(R.string.tombol_proceed))
    }
}
