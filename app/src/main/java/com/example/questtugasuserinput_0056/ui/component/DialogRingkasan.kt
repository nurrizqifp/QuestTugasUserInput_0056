package com.example.questtugasuserinput_0056.ui.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.questtugasuserinput_0056.R

@Composable
fun DialogRingkasan(
    ringkasan: String,
    onTutup: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onTutup,
        title = { Text(stringResource(R.string.judul_dialog_ringkasan)) },
        text = { Text(ringkasan) },
        confirmButton = {
            TextButton(onClick = onTutup) {
                Text(stringResource(R.string.tombol_dialog_tutup))
            }
        },
    )
}
