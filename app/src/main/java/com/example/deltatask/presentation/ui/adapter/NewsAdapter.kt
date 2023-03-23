package com.example.deltatask.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deltatask.data.model.Articles
import com.example.deltatask.databinding.RvItemsBinding
import com.example.deltatask.presentation.ui.activity.NewDetails

class NewsAdapter(var data: List<Articles>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size

    inner class ViewHolder(private val binding: RvItemsBinding) : RecyclerView.ViewHolder(binding.root) {
       init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, NewDetails::class.java)
                intent.putExtra("desc",data.get(adapterPosition).description)
                intent.putExtra("url",data.get(adapterPosition).url)
                intent.putExtra("author",data.get(adapterPosition).author)
                itemView.context.startActivity(intent)
                // Toast.makeText(itemView.context, data[adapterPosition].name, Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(item: Articles) = with(itemView) {
            binding.listItem=item
        }
       /* companion object {
            fun create(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RvItemsBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }*/
    }
}