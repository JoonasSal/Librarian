package com.example.librarian.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.librarian.R
import com.example.librarian.model.Book

@Composable
fun BookItem(book: Book) {
    val volumeInfo = book.volumeInfo

    val publishedDate = volumeInfo?.publishedDate
    val year = if (!publishedDate.isNullOrEmpty() && publishedDate.length >= 4) {
        publishedDate.take(4)
    } else {
        stringResource(id = R.string.unknown_year)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = volumeInfo?.title ?: stringResource(id = R.string.no_title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = volumeInfo?.authors?.joinToString(", ") ?: stringResource(id = R.string.unknown_author),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            //Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(id = R.string.published_year, year),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = { /* TODO */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = stringResource(id = R.string.add_to_favorites),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            //Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
