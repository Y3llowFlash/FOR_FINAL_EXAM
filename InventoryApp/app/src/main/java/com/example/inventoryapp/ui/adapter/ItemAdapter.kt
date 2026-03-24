package com.example.inventoryapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.inventoryapp.R
import com.example.inventoryapp.data.local.Item

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var itemList = emptyList<Item>()

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewItemName)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewItemPrice)
        val textViewQuantity: TextView = itemView.findViewById(R.id.textViewItemQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.textViewName.text = "Name: ${currentItem.itemName}"
        holder.textViewPrice.text = "Price: ${currentItem.itemPrice}"
        holder.textViewQuantity.text = "Quantity: ${currentItem.itemQuantity}"
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setData(items: List<Item>) {
        itemList = items
        notifyDataSetChanged()
    }
}
