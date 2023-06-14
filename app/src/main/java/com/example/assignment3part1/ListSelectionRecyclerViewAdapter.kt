package com.example.assignment3part1

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment3part1.databinding.ListSelectionViewHolderBinding

class ListSelectionRecyclerViewAdapter(
    private val lists: MutableList<Int>
    ): RecyclerView.Adapter<ListSelectionViewHolder>()
{
    //val listTitles = arrayOf(1, 2, 3, 4, 5)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSelectionViewHolder {
        val binding = ListSelectionViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ListSelectionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    fun listsUpdated() {
        notifyItemInserted(lists.size-1)
    }


    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        val itemNumber = position + 1
        val facNumber = lists[position]
        holder.binding.itemNumber.text = itemNumber.toString()
        holder.binding.itemString.text = facNumber.toString()
    }
}