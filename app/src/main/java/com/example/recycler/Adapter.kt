package com.example.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.databinding.ItemRecyclerBinding
import com.example.viewState.viewStateForecast1


class Adapter: RecyclerView.Adapter<ViewHolder>() {    //содержит, обрабатывает и связывает данные со списком;

    private var items: List<viewStateForecast1> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: List<viewStateForecast1>){
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}


