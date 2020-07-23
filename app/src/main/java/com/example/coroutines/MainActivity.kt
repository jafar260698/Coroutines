package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutines.ViewModel.ShoppingViewModel
import com.example.coroutines.ViewModel.ShoppingViewModelFactory
import com.example.coroutines.db.ShoppingDatabase
import com.example.coroutines.db.ShoppingItem
import com.example.coroutines.repository.ShoppingRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG="MainActivity"
    private lateinit var viewModel: ShoppingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      val database=ShoppingDatabase(this)
      val repository=ShoppingRepository(database)
      val factory=
          ShoppingViewModelFactory(repository)

       viewModel=ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val adapter=ShoppingItemAdapter(listOf(),viewModel)
        rvShoppingItems.layoutManager=LinearLayoutManager(this)
        rvShoppingItems.adapter=adapter
        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items=it
            adapter.notifyDataSetChanged()

        })
        fab.setOnClickListener {
            AddShoppingItemDialog(this,object :addDialogInterface{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.insert(item)
                }
            }).show()
        }

    }
}