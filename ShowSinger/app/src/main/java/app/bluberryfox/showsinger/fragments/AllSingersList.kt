package app.bluberryfox.showsinger.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.adapters.SingerListAdapter
import app.bluberryfox.showsinger.models.Singer
import app.bluberryfox.showsinger.ui.SingerInfo
import com.google.gson.Gson
import kotlinx.android.synthetic.main.singers_list.*
import okhttp3.OkHttpClient
import okhttp3.Request


class AllSingersList : Fragment() {
    companion object {
        fun newInstance(): AllSingersList {
            return AllSingersList()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.singers_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Thread(Runnable {
            val client = OkHttpClient()
            val request = Request.Builder()
                    .url("http://192.168.1.11/backend/?controller=commonList")
                    .build()
            val response = client.newCall(request).execute()
            val responseText = response.body()!!.string()
            var repos = Gson().fromJson(responseText, Singer.List::class.java)
            activity!!.runOnUiThread {
                val adapter = SingerListAdapter(this.context!!, repos) {
                    var intent = Intent(view!!.context, SingerInfo::class.java)
                    intent.putExtra("singer_name", it.name)
                    startActivity(intent)
                }
                recyclerView.adapter = adapter
            }
        }).start()
        recyclerView.layoutManager = LinearLayoutManager(view?.context, LinearLayout.VERTICAL, false)
    }
}