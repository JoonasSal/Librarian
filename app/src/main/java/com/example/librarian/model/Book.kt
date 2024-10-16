package com.example.librarian.model

data class Book(
    val id: String?,
    val volumeInfo: VolumeInfo?
)

data class VolumeInfo(
    val title: String?,
    val authors: List<String>?,
    val description: String?,
    val imageLinks: ImageLinks?
)

data class ImageLinks(
    val smallThumbnail: String?,
    val thumbnail: String?
)
