package com.talmeida.recyclerviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = resources.getInteger(R.integer.orientation)
        initializeRecyclerView();
    }

    private fun initializeRecyclerView() {

        val isTablet = resources.getBoolean(R.bool.isTablet);
        if (isTablet) {
            recyclerView.layoutManager = GridLayoutManager(this, 3)
        } else {
            recyclerView.layoutManager = LinearLayoutManager(this);
        }

        var colors = getColors();
        recyclerView.adapter = ColorsAdapter(colors);
    }

    private fun getColors(): List<Color> {
        val colors = resources.obtainTypedArray(R.array.material_colors)

        return (0 until colors.length())
                .map { idx ->
                    val color = colors.getColor(idx, 0)
                    Color(idx, color)
                }

    }
}
