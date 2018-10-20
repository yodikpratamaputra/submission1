package com.example.samsung.submission1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                image.getResourceId(i, 0)))
        }

        //Recycle the typed array
        image.recycle()
    }
    private var items: MutableList<Item> = mutableListOf()



    override fun onCreate(savedInstanceState: Bundle?) {

        initData()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items)
    }
}
