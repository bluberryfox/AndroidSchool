package csu.iit.ru.showsinger.ui

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import csu.iit.ru.showsinger.R

/**
 * Created by user on 27.02.2018.
 */
class GenresActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.genres_activity)
        var genresList = findViewById<ListView>(R.id.genres_list)
        val genresNames = ArrayList<String>()
        genresNames.add("Рок")
        genresNames.add("Поп")
        genresNames.add("Инди")
        genresNames.add("Джаз")
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, genresNames)
        genresList.adapter = adapter


    }


}