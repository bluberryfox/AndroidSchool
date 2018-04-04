package app.bluberryfox.showsinger

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import app.bluberryfox.showsinger.dao.SingerDao
import app.bluberryfox.showsinger.data.Singer

@Database(entities=[Singer::class], version = 1, exportSchema = false)
abstract  class Database:RoomDatabase(){
    abstract  fun singerDao(): SingerDao
}