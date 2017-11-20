package com.talmeida.recyclerviewdemo

import android.support.v7.util.DiffUtil
import com.talmeida.recyclerviewdemo.shuffle.GotCharacter


class MyDiffCallback(val oldList : List<GotCharacter>, val newList : List<GotCharacter>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].imageId == newList[newItemPosition].imageId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
