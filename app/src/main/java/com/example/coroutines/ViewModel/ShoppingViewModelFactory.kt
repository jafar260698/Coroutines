package com.example.coroutines.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coroutines.repository.ShoppingRepository
@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(
    private val repository: ShoppingRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}