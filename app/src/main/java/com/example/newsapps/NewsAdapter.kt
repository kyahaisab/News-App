package com.example.newsapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.lang.System.load

class NewsAdapter(val listner: ItemTouch) : RecyclerView.Adapter<NewsViewHolder>() {
    val item = ArrayList<News>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_news, parent, false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener {
            listner.onItemClicked(item[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.titleView.text = item[position].title
        holder.author.text=item[position].author
       Glide.with(holder.itemView.context).load(item[position].imageToUrl).into(holder.image)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun updateNews(updatedItems: ArrayList<News>) {
        item.clear()
        item.addAll(updatedItems)

        notifyDataSetChanged()// upar ke teeno fun dobara se call honge after update news
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.title)
val image:ImageView=itemView.findViewById(R.id.image)
    val author:TextView=itemView.findViewById(R.id.author)
}

interface ItemTouch {
    fun onItemClicked(st: News)
}