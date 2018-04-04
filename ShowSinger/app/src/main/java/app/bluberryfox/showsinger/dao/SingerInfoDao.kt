package app.bluberryfox.showsinger.dao

import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import app.bluberryfox.showsinger.data.Singer

interface SingerInfoDao {
    @Query("SELECT * FROM SingerInfo")
    fun getAll():List<Singer>

    @Insert
    fun unsertAll(singers:List<Singer>)