package app.bluberryfox.showsinger

import android.app.Application
import android.arch.persistence.room.Room

/**
 * Created by user on 27.03.2018.
 */
class App: Application(){

    companion object {
        var database:Database? = null
    }

    override fun onCreate() {
        super.onCreate()
        App.database = Room.databaseBuilder(this, Database::class.java, "singer_db").build()
    }

}