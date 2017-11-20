package com.talmeida.recyclerviewdemo

import com.talmeida.recyclerviewdemo.shuffle.GotCharacter


fun getGotCharacters(): List<GotCharacter> {
    var list = mutableListOf<GotCharacter>()
    list.add(GotCharacter("Daenerys Targaryen", R.drawable.danny))
    list.add(GotCharacter("John Snow", R.drawable.snow))
    list.add(GotCharacter("Joffrey Baratheon", R.drawable.joffrey))
    list.add(GotCharacter("Arya Stark", R.drawable.arya))
    list.add(GotCharacter("Sir Bronn", R.drawable.bronn))
    list.add(GotCharacter("Cersei Lannister", R.drawable.cersei))
    list.add(GotCharacter("Ed Stark", R.drawable.ed))
    list.add(GotCharacter("Sansa Stark", R.drawable.sansa))
    list.add(GotCharacter("Tyrion Lannister", R.drawable.tyrion))
    list.add(GotCharacter("Gendry", R.drawable.gendry))
    list.add(GotCharacter("The Mountain", R.drawable.gregor))

    return list


}