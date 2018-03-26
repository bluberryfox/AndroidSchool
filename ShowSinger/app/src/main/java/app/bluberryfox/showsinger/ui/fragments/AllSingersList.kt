package app.bluberryfox.showsinger.ui.fragments

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
import app.bluberryfox.showsinger.network.DataLoader
import app.bluberryfox.showsinger.ui.activity.SingerInfo
import kotlinx.android.synthetic.main.singers_list.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch


class AllSingersList : Fragment() {
    private val URL:String = "http://192.168.1.11/backend/"
    private val dataLoader= DataLoader()
    companion object {
        fun newInstance(): AllSingersList {
            return AllSingersList()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.singers_list, container, false)

    }


    private fun showSinger(singers: ArrayList<Singer>){
        val adapter = SingerListAdapter(this.context!!, singers, URL) {
            var intent = Intent(view!!.context, SingerInfo::class.java)
            intent.putExtra("singer_name", it.name)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launch(UI) {
            val job = dataLoader.loadDataAsync(URL)
            showSinger(job.await())
        }
        recyclerView.layoutManager = LinearLayoutManager(view?.context, LinearLayout.VERTICAL, false)

}


}


