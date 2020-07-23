package com.example.coroutines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutines.ViewModel.ShoppingViewModel
import com.example.coroutines.db.ShoppingItem
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
):RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){

    class ShoppingViewHolder(itemview:View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
      return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        holder.itemView.tvName.text=items[position].name
        holder.itemView.tvAmount.text= items[position].amount.toString()
        holder.itemView.ivDelete.setOnClickListener{
            viewModel.delete(items[position])

        }
        holder.itemView.ivPlus.setOnClickListener {
            val currentitem= items[position]
            currentitem.amount++
            viewModel.insert(currentitem)
        }
        holder.itemView.ivMinus.setOnClickListener {
            val currentitem= items[position]
            if (currentitem.amount>0){
                currentitem.amount--
                viewModel.insert(currentitem)
            }
        }

    }

}