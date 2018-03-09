package app.bluberryfox.showsinger.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import app.bluberryfox.showsinger.R

/**
 * Created by user on 08.03.2018.
 */
class SingerInfo: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.singer_info)
        var toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white)
        setSupportActionBar(toolbar)
    }

}