package com.example.coroutines

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.coroutines.db.ShoppingItem
import kotlinx.android.synthetic.main.dialog_item_add.*

class AddShoppingItemDialog(
    context: Context,var dialogListener:addDialogInterface) :AppCompatDialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_item_add)


        btn_save.setOnClickListener {
            val name=etName.text.toString()
            val amount=etAmount.text.toString().toInt()
            if(name.isNullOrEmpty()) {
                Toast.makeText(context,"Please enter the data",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val  item =ShoppingItem(name,amount)
            dialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tvCancel.setOnClickListener {
            cancel()
        }
    }

}