package app.bluberryfox.showsinger

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import app.bluberryfox.showsinger.dao.SingerDao
import app.bluberryfox.showsinger.dao.SingerInfoDao
import app.bluberryfox.showsinger.data.Singer
import app.bluberryfox.showsinger.data.SingerInfo

@Database(entities = [Singer::class, SingerInfo::class], version = 3)
abstract class ShowSingerDatabase : RoomDatabase() {
    abstract fun singersDao(): SingerDao
    abstract fun singerInfoDao(): SingerInfoDao
}
