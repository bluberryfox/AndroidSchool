package app.bluberryfox.showsinger.models


/**
 * Created by user on 08.03.2018.
 */
data class Singer(val id: String, val name : String, val image : String, val genre: String){
    class List : ArrayList<Singer>()
}