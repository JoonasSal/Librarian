package com.example.librarian.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.librarian.model.Book
import com.example.librarian.network.BooksApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BooksViewModel : ViewModel() {
    private val apiService = BooksApiService()

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> get() = _books

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun searchBooks(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val result = apiService.searchBooks(query)
                if (result != null) {
                    _books.value = result
                } else {
                    _error.value = "Failed to fetch books."
                }
            } catch (e: Exception) {
                _error.value = "An error occurred: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
