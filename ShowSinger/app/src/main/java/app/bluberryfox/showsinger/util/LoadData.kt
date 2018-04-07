package app.bluberryfox.showsinger.util

import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.data.Singer
import app.bluberryfox.showsinger.data.SingerInfo
import com.google.gson.Gson
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by user on 26.03.2018.
 */

//TODO:когда знаешь про полиморфизм, но не используешь -__-
fun loadSingers(url: String) = async(CommonPool) {
    val client = OkHttpClient()
    val request = Request.Builder()
            .url("$url?controller=commonList")
            .build()
    val response = client.newCall(request).execute()
    val responseText = response.body()!!.string()
    val singers = Gson().fromJson(responseText, Singer.List::class.java)
    singers
}

fun loadSingerInfo(url: String, id: Int) = async(CommonPool) {
    val client = OkHttpClient()
    val request = Request.Builder()
            .url("$url?controller=singer&id=$id")
            .build()
    val response = client.newCall(request).execute()
    val responseText = response.body()!!.string()
    val singers = Gson().fromJson(responseText, SingerInfo::class.java)
    singers
}

fun loadingSingersFromCache(app: App): Deferred<List<Singer>> = async(CommonPool) {
    app.database.singersDao().getAll()
}

fun selectSpecial(app: App,id: Long): Deferred<List<Singer>> = async(CommonPool) {
    app.database.singersDao().selectSpecial(id)
}

fun loadingSingersInfoFromCache(app: App, position: Long): Deferred<SingerInfo?> = async(CommonPool) {
    app.database.singerInfoDao().getSingerInfo(position)
}


