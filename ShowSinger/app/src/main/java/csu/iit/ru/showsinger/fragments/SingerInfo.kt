package csu.iit.ru.showsinger.fragments

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import csu.iit.ru.showsinger.R

/**
 * Created by user on 22.02.2018.
 */
class SingerInfo: Activity() {
    //TODO: ANKO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.singer_info)
        //todo:это должно все же быть фрагментом и с тулбаром, чтобы можно было как-то переключать, если не нравится
        var img = findViewById<ImageView>(R.id.imageView)
        img.setImageResource(R.drawable.album1)
        //TODO: ВЫНЕСТИ КОНСТАНТЫ В РЕСУРСЫ
        //TODO: ДОБАВИТЬ ДВЕ КНОПКИ - В ПЛАНАХ И ПОСЛУШАНО и придумать, как подменять эти кнопки - нужно думать с базой
        var singerName = findViewById<TextView>(R.id.singerName)
        singerName.text = "Испольнитель: Imagine Dragons"
        var favoriteSong = findViewById<TextView>(R.id.popularSong)
        favoriteSong.text = "Самая популярная песня: Demons"
        var favoriteAlbum = findViewById<TextView>(R.id.popularAlbum)
        favoriteAlbum.text = "Самый популярный альбом: Rise Up"
    }

}