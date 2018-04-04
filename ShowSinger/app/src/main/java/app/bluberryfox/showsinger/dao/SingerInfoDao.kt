package app.bluberryfox.showsinger.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Query
import app.bluberryfox.showsinger.data.SingerInfo

@Dao
interface SingerInfoDao{
    @Query("SELECT * FROM SingerInfo WHERE id =:id")
    fun getSingerInfo(id:Int): SingerInfo?

    @Delete
    fun insertSingerInfo(singerInfo:SingerInfo)



}