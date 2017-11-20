package com.talmeida.recyclerviewdemo.nested

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.talmeida.recyclerviewdemo.R
import com.talmeida.recyclerviewdemo.getGotCharacters
import com.talmeida.recyclerviewdemo.GotCharactersAdapter
import kotlinx.android.synthetic.main.activity_scroll_parent_recycler_view.*

class ScrollParentRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_parent_recycler_view)
        recyclerView.isNestedScrollingEnabled = false

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager.isAutoMeasureEnabled = true
        recyclerView.adapter = GotCharactersAdapter(getGotCharacters().takeLast(4))

    }
}
