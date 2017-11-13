package com.talmeida.recyclerviewdemo.shuffle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.talmeida.recyclerviewdemo.GotCharactersAdapter
import com.talmeida.recyclerviewdemo.R
import com.talmeida.recyclerviewdemo.getGotCharacters
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

        recyclerView.setHasFixedSize(true)
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


}
