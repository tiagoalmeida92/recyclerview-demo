package com.talmeida.recyclerviewdemo.shuffle

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.talmeida.recyclerviewdemo.R


class GotCharactersAdapter(var characters : List<GotCharacter>) : RecyclerView.Adapter<GotCharactersAdapter.ViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var character = characters[position]
        holder.image.setImageResource(character.imageId)
        holder.name.text = character.name
        //holder.cardView.setCardBackgroundColor(color.value)
        //holder.numberTextView.text = ""+color.id
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun getItemId(position: Int): Long {
        return characters[position].imageId.toLong()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView
        var name: TextView

        init {
            image = itemView.findViewById(R.id.image)
            name = itemView.findViewById(R.id.characterName)
        }
    }
}
