package app.bluberryfox.showsinger.data


/**
 * Created by user on 08.03.2018.
 */
data class Singer(val id: Int, val name : String, val image : String, val genre: String){
    class List : ArrayList<Singer>()
}