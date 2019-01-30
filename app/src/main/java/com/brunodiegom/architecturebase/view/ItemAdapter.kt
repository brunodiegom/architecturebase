package com.brunodiegom.architecturebase.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brunodiegom.architecturebase.R
import com.brunodiegom.architecturebase.model.Item
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    private var list: List<Item>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemHolder(itemView)
    }

    override fun getItemCount() = list?.size ?: 0

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            list?.get(position)?.let {
            holder.name.text = it.name
            holder.birthday.text = it.birthday
        }
    }

    fun setItems(items : List<Item>) {
        list = items
        notifyDataSetChanged()
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.item_name
        val birthday: TextView = itemView.item_birthday
    }
}