package com.example.coroutines.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping")
data class ShoppingItem(

    @ColumnInfo(name="item_name")
    var name:String,
    @ColumnInfo(name="item_amount")
    var amount:Int
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id:Int?=null
}