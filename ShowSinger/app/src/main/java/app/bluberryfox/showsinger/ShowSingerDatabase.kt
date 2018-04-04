package app.bluberryfox.showsinger

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import app.bluberryfox.showsinger.dao.SingerDao
import app.bluberryfox.showsinger.data.Singer

@Database(entities=[Singer::class], version = 1)
    abstract class ShowSingerDatabase: RoomDatabase(){
        abstract fun singersDao(): SingerDao
    }
