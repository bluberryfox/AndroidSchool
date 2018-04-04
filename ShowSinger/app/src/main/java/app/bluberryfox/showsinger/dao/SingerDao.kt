package app.bluberryfox.showsinger.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import app.bluberryfox.showsinger.data.Singer

@Dao
interface SingerDao {
    @Query("SELECT * FROM Singer")
    fun getAll():List<Singer>

    @Insert
    fun insertAll(singers:List<Singer>)
}