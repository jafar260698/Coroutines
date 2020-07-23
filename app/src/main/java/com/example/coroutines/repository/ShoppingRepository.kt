package com.example.coroutines.repository

import com.example.coroutines.db.ShoppingDatabase
import com.example.coroutines.db.ShoppingItem

class ShoppingRepository(private val db:ShoppingDatabase) {
    suspend fun insert(item:ShoppingItem)=db.getShopping().insert(item)

    suspend fun delete(item: ShoppingItem)=db.getShopping().delete(item)

    fun detallShoppingItems()=db.getShopping().getAllShoppingItem()


}