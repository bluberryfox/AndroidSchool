package app.bluberryfox.showsinger.ui.singerinfo

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.data.SingerInfo
import app.bluberryfox.showsinger.util.Constants
import com.bumptech.glide.Glide

/**
 * Created by user on 08.03.2018.
 */
class SingerInfoActivity: AppCompatActivity(), SingerInfoContract.View{

    override fun getId():Int {
        return intent.getIntExtra("id", 0)
    }
    override fun showSingerInfo(singer: SingerInfo) {
        val song = findViewById<TextView>(R.id.popularSong)
        val desc  = findViewById<TextView>(R.id.description)
        val image = findViewById<ImageView>(R.id.imageView)
        desc.text =  singer.description
        song.text = getString(R.string.recommend_song, singer.song)
        Glide.with(this).load(Constants.URL + intent.getStringExtra("image")).into(image)
    }
    private var singerInfoPresenter = SingerInfoPresenter(applicationContext, application as App, getId() )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.singer_info)
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setBackgroundColor(Color.TRANSPARENT)
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

    override fun onResume() {
        super.onResume()
        singerInfoPresenter.attachView(this)
    }

    override fun onDestroy() {
        singerInfoPresenter.detachView()
        super.onDestroy()
    }

}