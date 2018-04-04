package app.bluberryfox.showsinger.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class SingerInfo(@PrimaryKey val id:Int, val song:String, val description:String){
}