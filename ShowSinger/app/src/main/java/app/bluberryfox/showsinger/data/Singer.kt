package app.bluberryfox.showsinger.data

data class Singer(val id: Int, val name: String, val image: String, val genre: String) {
    class List : ArrayList<Singer>()
}