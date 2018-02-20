package csu.iit.ru.myapplication.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import csu.iit.ru.myapplication.R
import csu.iit.ru.myapplication.adapters.GenreAdapter
import csu.iit.ru.myapplication.models.GenreInfo


class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        var genres = ArrayList<GenreInfo>()
        genres.add(GenreInfo("Pop"))
        genres.add(GenreInfo("Rock"))
        genres.add(GenreInfo("Indi"))
        genres.add(GenreInfo("Metal"))
        genres.add(GenreInfo("Alternative"))
        var adapter = GenreAdapter(genres)


    }
}
