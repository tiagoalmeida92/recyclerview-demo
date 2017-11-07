package com.talmeida.recyclerviewdemo.shuffle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.talmeida.recyclerviewdemo.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var colorList : List<Color>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = resources.getInteger(R.integer.orientation)
        initializeRecyclerView();
    }

    private fun initializeRecyclerView() {

        val isTablet = resources.getBoolean(R.bool.isTablet);
        if (isTablet) {
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        } else {
//            recyclerView.layoutManager = LinearLayoutManager(this);
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }

        colorList = getColors();
        recyclerView.adapter = ColorsAdapter(colorList);
    }

    private fun getColors(): List<Color> {
        val colors = resources.obtainTypedArray(R.array.material_colors)

        return (0 until colors.length())
                .map { idx ->
                    val color = colors.getColor(idx, 0)
                    Color(idx, color)
                }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.shuffle -> {
                shuffle()
                return true
            }
        }
        return false
    }

    private fun shuffle() {
        Collections.shuffle(colorList);
        recyclerView.adapter.notifyDataSetChanged()
    }
}
