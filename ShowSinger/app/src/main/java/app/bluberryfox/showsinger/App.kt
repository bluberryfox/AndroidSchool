package app.bluberryfox.showsinger

import android.app.Application
import android.arch.persistence.room.Room

/**
 * Created by user on 27.03.2018.
 */
class App: Application(){

    lateinit var database: ShowSingerDatabase
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, ShowSingerDatabase::class.java, "singers")
                .fallbackToDestructiveMigration()
                .build()
    }

}