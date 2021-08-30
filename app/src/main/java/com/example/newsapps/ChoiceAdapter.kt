package com.example.newsapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChoiceAdapter(val listOfChoice: ArrayList<String>, val listner2:ChoiceInterface) : RecyclerView.Adapter<ChoiceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoiceViewHolder {
        val vieww=LayoutInflater.from(parent.context).inflate(R.layout.activity_choice,parent,false)
        val viewHolderr=ChoiceViewHolder(vieww)
        vieww.setOnClickListener {
            listner2.onChoiceClicked(viewHolderr.adapterPosition)
        }
        return viewHolderr
    }

    override fun onBindViewHolder(holder: ChoiceViewHolder, position: Int) {
        holder.choice.text=listOfChoice[position]
    }

    override fun getItemCount(): Int {
        return listOfChoice.size
    }
}

class ChoiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val choice: TextView = itemView.findViewById(R.id.choice_type)
}

interface ChoiceInterface{
    fun onChoiceClicked(t: Int)
}
