package com.example.samsung.submission1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        val list = findViewById<RecyclerView>(R.id.club_list)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
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