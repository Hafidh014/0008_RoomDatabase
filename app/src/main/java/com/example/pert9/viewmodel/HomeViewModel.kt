package com.example.pert9.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pert9.repositori.RepositoriSiswa
import com.example.pert9.room.Siswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class HomeUiState(val listSiswa: List<Siswa> = emptyList())

class HomeViewModel(private val repositoriSiswa: RepositoriSiswa) : ViewModel() {
    val homeUiState: StateFlow<HomeUiState> = repositoriSiswa.getAllSiswaStream()
        .map { HomeUiState(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), HomeUiState())
}
