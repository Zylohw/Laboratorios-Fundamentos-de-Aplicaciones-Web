package com.curso.android.module2.stream.ui.screens
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

import com.curso.android.module2.stream.data.model.Category
import com.curso.android.module2.stream.data.model.Song
import com.curso.android.module2.stream.ui.viewmodel.*
import com.curso.android.module2.stream.ui.components.SongCoverMock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
private fun SongCard(
    song: Song,
    onClick: () -> Unit,
    onFavoriteClick:(String)->Unit
) {
    Column(
        modifier = Modifier
            .width(120.dp)
            // clickable hace que toda la columna sea interactiva
            // También añade feedback visual (ripple effect)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Cover generado por código
        SongCoverMock(
            colorSeed = song.colorSeed,
            size = 120.dp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Título de la canción
        Text(
            text = song.title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis, // "..." si el texto es muy largo
            modifier = Modifier.fillMaxWidth()
        )

        // Artista
        Text(
            text = song.artist,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
        IconButton(
            onClick = { onFavoriteClick(song.id) }
        ) {
            Icon(
                imageVector =
                    if (song.isFavorite) Icons.Filled.Favorite
                    else Icons.Outlined.FavoriteBorder,
                contentDescription = "Favorite"
            )
        }


    }
}

@Composable
fun FavoritesScreen(
    viewModel: HomeViewModel,
    onSongClick: (Song) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    val favoriteSongs = if (uiState is HomeUiState.Success) {
        (uiState as HomeUiState.Success).categories
            .flatMap { it.songs }
            .filter { it.isFavorite }
    } else emptyList()

    if (favoriteSongs.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No tienes canciones favoritas aún 😢")
        }
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
                    onFavoriteClick = { viewModel.toggleFavorite(it) }
                )
            }
        }
    }
}

