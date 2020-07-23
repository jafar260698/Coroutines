package com.example.coroutines

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.coroutines.db.ShoppingItem
import kotlinx.android.synthetic.main.dialog_item_add.*

class AddShoppingItemDialog(
    context: Context,var dialogListener:addDialogInterface) :AppCompatDialog(context){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvAdd.setOnClickListener {
            val name=etName.text.toString()
            val amount=etAmount.text.toString()
            if (name.isEmpty()||amount.isEmpty()){
                Toast.makeText(context,"Please enter the data",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val  item =ShoppingItem(name,amount.toInt())
            dialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tvCancel.setOnClickListener {
            cancel()
        }
    }

}