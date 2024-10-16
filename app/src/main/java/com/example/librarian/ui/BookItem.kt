package com.example.librarian.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.librarian.model.Book
import coil.compose.AsyncImage

@Composable
fun BookItem(book: Book) {
    val volumeInfo = book.volumeInfo
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation()
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            if (volumeInfo?.imageLinks?.thumbnail != null) {
                AsyncImage(
                    model = volumeInfo.imageLinks.thumbnail,
                    contentDescription = volumeInfo.title,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(end = 8.dp)
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = volumeInfo?.title ?: "No Title",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = volumeInfo?.authors?.joinToString(", ") ?: "Unknown author",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Button(
                        onClick = { /* TODO mark book as read */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Text(text = "Read")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { /* TODO add book to a list "want to read" */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = MaterialTheme.colorScheme.onSecondary
                        )
                    ) {
                        Text(text = "Want to Read")
                    }
                }
            }
        }
    }
}
