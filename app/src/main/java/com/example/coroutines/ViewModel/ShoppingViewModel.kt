package com.example.coroutines.ViewModel

import androidx.lifecycle.ViewModel
import com.example.coroutines.db.ShoppingItem
import com.example.coroutines.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
):ViewModel(){
    fun insert(item: ShoppingItem)= CoroutineScope(Dispatchers.Main).launch {
        repository.insert(item)
    }

    fun delete(item: ShoppingItem)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems()=repository.detallShoppingItems()

}