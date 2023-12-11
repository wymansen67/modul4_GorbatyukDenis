package com.example.worldcinematest.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcinematest.R
import com.example.worldcinematest.databinding.ItemBinding

class MenuItemAdapter(private val listener: Listener) :

    RecyclerView.Adapter<MenuItemAdapter.MenuItemHolder>() {

    private val menuItemList = ArrayList<MenuItem>()

    class MenuItemHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemBinding.bind(item)
        fun bind(menuItem: MenuItem, listener: Listener) = with(binding) {
            itemIcon.setImageResource(menuItem.imageId)
            itemName.text = menuItem.itemName
            itemView.setOnClickListener {
                listener.onClick(menuItem.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MenuItemHolder(view)
    }

    override fun onBindViewHolder(holder: MenuItemHolder, position: Int) {
        holder.bind(menuItemList[position], listener)
    }

    override fun getItemCount(): Int {
        return menuItemList.size
    }

    fun addDiscussion(list: List<MenuItem>) {
        menuItemList.clear()
        menuItemList.addAll(list)
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick(itemId: Int)
    }
}