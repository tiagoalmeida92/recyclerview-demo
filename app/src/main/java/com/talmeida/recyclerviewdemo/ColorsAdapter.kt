package com.talmeida.recyclerviewdemo

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ColorsAdapter(var colors : List<Color>) : RecyclerView.Adapter<ColorsAdapter.ViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var color = colors[position]
        holder.cardView.setCardBackgroundColor(color.value)
        holder.numberTextView.setText(""+position)
    }

    override fun getItemCount(): Int {
        return colors.size
    }

    override fun getItemId(position: Int): Long {
        return colors[position].id.toLong()
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
