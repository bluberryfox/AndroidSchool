package app.bluberryfox.showsinger

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context

/**
 * Created by user on 27.03.2018.
 */
class App: Application(){

    lateinit var database: Database
    val context: Context = applicationContext

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, Database::class.java, "singer_db").build()
    }

}