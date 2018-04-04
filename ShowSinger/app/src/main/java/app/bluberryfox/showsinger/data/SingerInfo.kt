package app.bluberryfox.showsinger.data

import android.arch.persistence.room.Entity

@Entity
data class SingerInfo(val id:Int, val song:String, val description:String){
}