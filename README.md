# QuestTugasUserInput_0056

**Nama:** Nur Rizqi Febriansyah Putra  
**NIM:** 20240140056  
**Judul tugas:** Form Biodata dengan Jetpack Compose

## Deskripsi

Aplikasi Android ini menampilkan form biodata menggunakan Kotlin dan Jetpack
Compose Material 3. Latar aplikasi memakai gambar bunga bernuansa neon yang
disediakan pemilik.

## Aturan implementasi

- Seluruh teks, warna, ukuran, ikon, dan gambar UI diletakkan di resource
  `app/src/main/res/`.
- Antarmuka dibuat sepenuhnya dengan Jetpack Compose.
- Kartu form mengapung di atas `Scaffold` dengan bayangan dan jarak dari tepi.
- Tombol Proceed aktif setelah semua isian wajib valid dan menampilkan ringkasan
  biodata.
- Perubahan disusun dalam commit kecil dengan pesan berbahasa Indonesia.

## Menjalankan proyek

Buka proyek di Android Studio dan tunggu Gradle selesai melakukan sinkronisasi.
Untuk memeriksa build debug dari terminal:

```powershell
.\gradlew.bat assembleDebug
```

Setelah build berhasil, jalankan aplikasi melalui emulator atau perangkat
Android dari Android Studio.
