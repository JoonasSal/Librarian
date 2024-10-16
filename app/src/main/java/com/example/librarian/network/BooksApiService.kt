package com.example.librarian.network

import com.example.librarian.model.Book
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BooksApiService {
    private val client = OkHttpClient()
    private val gson = Gson()

    suspend fun searchBooks(query: String): List<Book>? {
        return withContext(Dispatchers.IO) {
            val url = "https://www.googleapis.com/books/v1/volumes?q=$query"
            val request = Request.Builder().url(url).build()
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    val body = response.body?.string()
                    if (body != null) {
                        val booksResponse = gson.fromJson(body, BooksResponse::class.java)
                        booksResponse.items
                    } else {
                        null
                    }
                } else {
                    null
                }
            }
        }
    }
}

data class BooksResponse(
    val items: List<Book> = emptyList()
)
