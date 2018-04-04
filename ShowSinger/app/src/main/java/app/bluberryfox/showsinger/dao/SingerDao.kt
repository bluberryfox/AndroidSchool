package app.bluberryfox.showsinger.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import app.bluberryfox.showsinger.data.Singer

@Dao
interface SingerDao{
    @Query("SELECT * FROM singer")
    fun getAllSingers(): Singer.List

    @Insert
    fun insert(singer:Singer)

    @Delete
fun delete(singer:Singer)
}