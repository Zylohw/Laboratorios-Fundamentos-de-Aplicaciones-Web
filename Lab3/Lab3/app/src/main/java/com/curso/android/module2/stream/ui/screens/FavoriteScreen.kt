package com.curso.android.module2.stream.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.curso.android.module2.stream.data.model.Song
import com.curso.android.module2.stream.ui.components.SongCoverMock
import com.curso.android.module2.stream.ui.viewmodel.HomeUiState
import com.curso.android.module2.stream.ui.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

// ---------------------
// Tarjeta individual de canción
// ---------------------
@Composable
private fun SongCard(
    song: Song,
    onClick: () -> Unit,
    onFavoriteClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SongCoverMock(colorSeed = song.colorSeed, size = 120.dp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = song.title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = song.artist,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
        IconButton(onClick = { onFavoriteClick(song.id) }) {
            Icon(
                imageVector = if (song.isFavorite) Icons.Filled.Favorite
                else Icons.Outlined.FavoriteBorder,
                contentDescription = "Favorite"
            )
        }
    }
}

// ---------------------
// Pantalla de Favoritos
// ---------------------
@Composable
fun FavoritesScreen(
    viewModel: HomeViewModel = koinViewModel(), // Inyecta el mismo HomeViewModel que HomeScreen
    onSongClick: (Song) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        when (uiState) {
            is HomeUiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            is HomeUiState.Error -> {
                Text(
                    text = "Error: ${(uiState as HomeUiState.Error).message}",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            is HomeUiState.Success -> {
                val favoriteSongs = (uiState as HomeUiState.Success)
                    .categories
                    .flatMap { it.songs }
                    .filter { it.isFavorite }

                if (favoriteSongs.isEmpty()) {
                    Text(
                        text = "No tienes canciones favoritas aún 😢",
                        modifier = Modifier.align(Alignment.Center)
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(favoriteSongs, key = { it.id }) { song ->
                            SongCard(
                                song = song,
                                onClick = { onSongClick(song) },
                                onFavoriteClick = { songId ->
                                    viewModel.toggleFavorite(songId)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
