package com.talmeida.recyclerviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val LIST_SIZE : Int = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeRecyclerView();
    }

    private fun initializeRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this);


        var colors = getColors();
        recyclerView.adapter = ColorsAdapter(colors);
    }

    private fun getColors(): MutableList<Color> {
        val colors = resources.obtainTypedArray(R.array.material_colors)
        var colorsResult = mutableListOf<Color>()

        var id: Long = 0
        for(i : Int in 1..LIST_SIZE){
            val index = (Math.random() * colors.length()).toInt()
            val color = colors.getColor(index, android.graphics.Color.BLACK)
            colorsResult.add(Color(id++, color))
        }
        colors.recycle()
        return colorsResult
    }
}
