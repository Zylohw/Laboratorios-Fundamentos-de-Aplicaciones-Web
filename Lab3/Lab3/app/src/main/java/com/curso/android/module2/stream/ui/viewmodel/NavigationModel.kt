package com.curso.android.module2.stream.ui.viewmodel
import androidx.lifecycle.ViewModel
import com.curso.android.module2.stream.data.model.Song
import com.curso.android.module2.stream.data.repository.MusicRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed interface NavigationUIState{
    data object Loading: NavigationUIState // estado incial

    // Datos cargados exitosamente.
    data class Success(
        val songs: List<Song>
    ): NavigationUIState

   // Datos cargados error o sea no cargaron
    data class Error(
        val message: String
    ): NavigationUIState
}


class NavigationModel(
    private val repository:MusicRepository
): ViewModel(){
    private val _uiState = MutableStateFlow<NavigationUIState>(NavigationUIState.Loading)
    val uiState: StateFlow<NavigationUIState> = _uiState.asStateFlow()

    init{
        loadFavorites()
    }

    // función para cargar categorias
    private fun loadFavotires(){
        _uiState.value = NavigationUIState.Loading
        val songs = repository.getAllSongs()
        _uiState.value = NavigationUIState.Success(songs)
    }

    fun refresh(){
        loadFavotires()
    }

    fun toggleFavorite(songId: String) {
        val currentState = _uiState.value

        if (currentState is HomeUiState.Success) {

            val updatedFavoties = currentState.categories.map { category ->
                category.copy(
                    songs = category.songs.map { song ->
                        if (song.id == songId) {
                            song.copy(isFavorite = !song.isFavorite)
                        } else {
                            song
                        }
                    }
                )
            }

            _uiState.value = NavigationUIState.Success(updatedFavoties)
        }
    }



}