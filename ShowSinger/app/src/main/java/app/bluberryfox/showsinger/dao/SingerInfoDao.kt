package app.bluberryfox.showsinger.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import app.bluberryfox.showsinger.data.SingerInfo

@Dao
interface SingerInfoDao{
    @Query("SELECT * FROM SingerInfo WHERE id = :id")
    fun getSingerInfo(id:Long):SingerInfo

    @Insert(onConflict = REPLACE)
    fun insertSingerInfo(singerInfo:SingerInfo)





}