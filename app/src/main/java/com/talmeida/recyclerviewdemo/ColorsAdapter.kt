package com.talmeida.recyclerviewdemo

import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ColorsAdapter : RecyclerView.Adapter<ColorsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val color = ContextCompat.getColor(holder.itemView.context, R.color.colorAccent)
        holder.cardView.setCardBackgroundColor(color)
        holder.numberTextView.setText(""+position);
    }

    override fun getItemCount(): Int {
        return 20
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var cardView: CardView
        var numberTextView : TextView

        init {
            cardView = itemView.findViewById(R.id.item)
            numberTextView = itemView.findViewById(R.id.itemNumber)
        }
    }
}
