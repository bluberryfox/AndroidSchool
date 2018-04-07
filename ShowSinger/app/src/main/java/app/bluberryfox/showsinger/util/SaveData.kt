package app.bluberryfox.showsinger.util

import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.data.Singer
import app.bluberryfox.showsinger.data.SingerInfo
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

fun saveSingers(app: App, singers: List<Singer>): Deferred<Unit> = async(CommonPool) {
    app.database.singersDao().insertAll(singers)
}
fun saveSingerInfo(app:App, singerInfo:SingerInfo):Deferred<Unit> = async(CommonPool){
    app.database.singerInfoDao().insertSingerInfo(singerInfo)
}
fun saveSingerToFavorite(app:App, id:Long):Deferred<Unit> = async(CommonPool){
    app.database.singersDao().addToFavorite(id)
}

