package csu.iit.ru.showsinger.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import csu.iit.ru.showsinger.R
import csu.iit.ru.showsinger.adapters.SingerListAdapter
import csu.iit.ru.showsinger.fragments.SingerInfo
import csu.iit.ru.showsinger.models.Singer
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = ArrayList<Singer>()
        prepareList(list)
        val rView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = SingerListAdapter( list, {
            var intent = Intent(this, SingerInfo::class.java)
            startActivity(intent)
        } )
        rView.adapter = adapter
        rView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val float_button = findViewById<FloatingActionButton>(R.id.fab)
        float_button.setOnClickListener({
            val intent = Intent(this, SingerInfo::class.java)
            startActivity(intent)
        }
        )

    }
    private fun prepareList(list : ArrayList<Singer>){
        list.add(Singer("ImagineDragons", "indi", R.drawable.album1))
        list.add(Singer("Slipknot", "metal", R.drawable.album2))
        list.add(Singer("System Of A Down", "rock", R.drawable.album3))
        list.add(Singer("Daughter", "indi", R.drawable.album4))
        list.add(Singer("Twenty One Pilots", "rock", R.drawable.album5))
    }
}
