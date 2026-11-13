package com.example.pert9.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pert9.repositori.RepositoriSiswa
import com.example.pert9.room.Siswa
import kotlinx.coroutines.launch

data class DetailSiswa(val nama: String = "", val alamat: String = "", val telpon: String = "")
data class UIStateSiswa(val detailSiswa: DetailSiswa = DetailSiswa()) {
    val isEntryValid: Boolean
        get() = detailSiswa.nama.isNotBlank() && detailSiswa.alamat.isNotBlank() && detailSiswa.telpon.isNotBlank()
}

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa) : ViewModel() {
    var uiStateSiswa: UIStateSiswa = UIStateSiswa()
        private set

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(detailSiswa)
    }

    suspend fun saveSiswa() {
        if (uiStateSiswa.isEntryValid) {
            repositoriSiswa.insertSiswa(
                Siswa(
                    nama = uiStateSiswa.detailSiswa.nama,
                    alamat = uiStateSiswa.detailSiswa.alamat,
                    telpon = uiStateSiswa.detailSiswa.telpon
                )
            )
        }
    }
}
