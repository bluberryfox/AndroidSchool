package csu.iit.ru.showsinger.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Toast
import csu.iit.ru.showsinger.R
import csu.iit.ru.showsinger.adapters.SingerAdapter
import csu.iit.ru.showsinger.fragments.SingerInfo
import csu.iit.ru.showsinger.models.Singer

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val singers = ArrayList<Singer>()
        singers.add(Singer("Arctic Monkeys"))
        singers.add(Singer("Slipknot"))
        singers.add(Singer("Muse"))
        singers.add(Singer("Самое большое простое число"))
        singers.add(Singer("Наадя"))

        var adapter = SingerAdapter(singers, { singer: Singer -> singerClicked(singer) })
        rv.adapter = adapter
    }
    private fun singerClicked(singer: Singer){
        Toast.makeText(this, "Clicked: ${singer.name}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, SingerInfo::class.java)
        startActivity(intent)
    }
}
