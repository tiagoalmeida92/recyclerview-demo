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

    lateinit var gotCharactersList : List<GotCharacter>

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
//            recyclerView.layoutManager = LinearLayoutManager(this);
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }

        gotCharactersList = getGotCharacters();
        recyclerView.adapter = GotCharactersAdapter(gotCharactersList);
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
        Collections.shuffle(gotCharactersList);
        recyclerView.adapter.notifyDataSetChanged()
    }

    private fun getGotCharacters(): List<GotCharacter> {
        var list = mutableListOf<GotCharacter>()
        list.add(GotCharacter("Daenerys Targaryen", R.drawable.danny))
        list.add(GotCharacter("John Snow", R.drawable.snow))
        list.add(GotCharacter("Joffrey Baratheon", R.drawable.joffrey))
        list.add(GotCharacter("Arya Stark", R.drawable.arya))
        list.add(GotCharacter("Sir Bronn", R.drawable.bronn))
        list.add(GotCharacter("Cersei Lannister", R.drawable.cersei))
        list.add(GotCharacter("Ed Stark", R.drawable.ed))
        list.add(GotCharacter("Gendry", R.drawable.gendry))
        list.add(GotCharacter("The Mountain", R.drawable.gregor))
        list.add(GotCharacter("Sansa Stark", R.drawable.sansa))
        list.add(GotCharacter("Tyrion Lannister", R.drawable.tyrion))


        return list

//        val colors = resources.obtainTypedArray(R.array.material_colors)
//
//        return (0 until colors.length())
//                .map { idx ->
//                    val color = colors.getColor(idx, 0)
//                    GotCharacter(idx, color)
//                }

    }

}
