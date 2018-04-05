package app.bluberryfox.showsinger.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import app.bluberryfox.showsinger.data.Singer

@Dao
interface SingerDao {
    @Query("SELECT * FROM Singer")
    fun getAll():List<Singer>

    @Insert(onConflict = REPLACE)
    fun insertAll(singers:List<Singer>)

    @Query("UPDATE Singer SET isFavorite = 1 WHERE id=:id")
    fun addToFavorite(id:Int)

    @Query("SELECT * FROM Singer WHERE isFavorite = :isFavorite")
    fun selectSpecial(isFavorite:Int):List<Singer>



}