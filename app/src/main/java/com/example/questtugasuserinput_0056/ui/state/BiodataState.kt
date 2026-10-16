package com.example.questtugasuserinput_0056.ui.state

import android.util.Patterns

data class BiodataState(
    val namaDepan: String = String(),
    val namaBelakang: String = String(),
    val email: String = String(),
    val tglLahir: String = String(),
    val indeksExperience: Int? = null,
    val skillTerpilih: Set<Int> = emptySet(),
) {
    fun formValid(): Boolean =
        namaDepan.isNotBlank() &&
            namaBelakang.isNotBlank() &&
            Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
            tglLahir.isNotBlank() &&
            indeksExperience != null &&
            skillTerpilih.isNotEmpty()
}
