package app.bluberryfox.showsinger.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import app.bluberryfox.showsinger.R
import org.jetbrains.anko.backgroundColor

/**
 * Created by user on 08.03.2018.
 */
class SingerInfo: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.singer_info)
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.backgroundColor = Color.TRANSPARENT
        var img = findViewById<ImageView>(R.id.imageView)
        img.setImageResource(R.drawable.fox)
        val singer = intent.getStringExtra("singer_name")
        toolbar.title = singer
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}