package app.bluberryfox.showsinger.network

import app.bluberryfox.showsinger.models.Singer
import com.google.gson.Gson
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by user on 26.03.2018.
 */
class DataLoader{
    fun loadDataAsync(url:String)=async(CommonPool){
        val client = OkHttpClient()
        val request = Request.Builder()
                .url("$url?controller=commonList")
                .build()
        val response = client.newCall(request).execute()
        val responseText = response.body()!!.string()
        var singers = Gson().fromJson(responseText, Singer.List::class.java)
        singers
    }
}