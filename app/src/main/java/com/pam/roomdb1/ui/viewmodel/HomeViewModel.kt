package com.pam.roomdb1.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pam.roomdb1.data.entity.Siswa
import com.pam.roomdb1.repositori.RepositorySiswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class HomeUiState(
    val daftarSiswa: List<Siswa> = listOf()
)

class HomeViewModel(private val repositorySiswa: RepositorySiswa): ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val uiState: StateFlow<HomeUiState> =
        repositorySiswa.getAllSiswaStream()
            .map{ HomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

}
