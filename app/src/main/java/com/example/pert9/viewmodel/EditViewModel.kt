package com.example.pert9.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pert9.repositori.RepositoriSiswa
import com.example.pert9.uicontroller.DestinasiDetailSiswa
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val idSiswa: Int = checkNotNull(
        savedStateHandle[DestinasiDetailSiswa.itemIdArg]
    )

    init {
        viewModelScope.launch {
            uiStateSiswa = repositoriSiswa.getSiswaStream(idSiswa)
                .filterNotNull()
                .first()
                .toUIStateSiswa(isEntryValid = true)
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(
            detailSiswa = detailSiswa,
            isEntryValid = validasiInput(detailSiswa)
        )
    }

    private fun validasiInput(detailSiswa: DetailSiswa = uiStateSiswa.detailSiswa): Boolean =
        detailSiswa.nama.isNotBlank() &&
            detailSiswa.alamat.isNotBlank() &&
            detailSiswa.telpon.isNotBlank()

    suspend fun updateSiswa() {
        if (validasiInput()) {
            repositoriSiswa.updateSiswa(uiStateSiswa.detailSiswa.toSiswa())
        }
    }
}
