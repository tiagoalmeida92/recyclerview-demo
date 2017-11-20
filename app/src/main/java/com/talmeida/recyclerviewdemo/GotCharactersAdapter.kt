package com.talmeida.recyclerviewdemo

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.talmeida.recyclerviewdemo.shuffle.GotCharacter


class GotCharactersAdapter(var characters: List<GotCharacter>) : RecyclerView.Adapter<GotCharactersAdapter.ViewHolder>() {

    val TAG: String = "GotCharactersAdapter"

    init {
//        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder")
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder Pos: " + position)
        var character = characters[position]
        holder.bindTo(character)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

//    override fun getItemId(position: Int): Long {
//        return characters[position].imageId.toLong()
//    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.image)
        var name: TextView = itemView.findViewById(R.id.characterName)

        fun bindTo(character: GotCharacter) {
            image.setImageResource(character.imageId)
            name.text = character.name
        }

    }
}
