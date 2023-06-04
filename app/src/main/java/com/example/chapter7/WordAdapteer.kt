package com.example.chapter7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter7.databinding.ItemBinding

class WordAdapter(
    private val list: MutableList<Word>,
    private  val itemClickListener: ItemClickListener? = null,
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ItemBinding.inflate(inflater, parent,false)
        return  WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = list[position]
        holder.bind(word)
        holder.itemView.setOnClickListener{itemClickListener?.onClick()}

    }

    override fun getItemCount() : Int {
        return list.size
    }

    class WordViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(word: Word) {
            binding.apply {
                textTextView.text = word.text
                meanTextView.text = word.mean
                typeChip.text = word.type
            }
            itemView.setOnClickListener {

            }
        }
    }
    interface  ItemClickListener {
        fun onClick(word:Word)
    }

}