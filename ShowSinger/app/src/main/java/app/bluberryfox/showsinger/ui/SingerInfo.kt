package app.bluberryfox.showsinger.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
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
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white)
        setSupportActionBar(toolbar)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_view, menu)
        return true
    }


}