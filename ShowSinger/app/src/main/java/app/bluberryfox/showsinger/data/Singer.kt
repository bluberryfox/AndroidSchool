package app.bluberryfox.showsinger.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Singer( @PrimaryKey val id: Int,  val name: String, val image: String, val genre: String, var isFavorite:Int = 0) {
    class List : ArrayList<Singer>()
}