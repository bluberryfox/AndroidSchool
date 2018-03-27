package app.bluberryfox.showsinger.ui.main.allsingers

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.ui.adapters.SingerListAdapter
import app.bluberryfox.showsinger.models.Singer
import app.bluberryfox.showsinger.network.DataLoader
import app.bluberryfox.showsinger.ui.singerinfo.SingerInfo
import app.bluberryfox.showsinger.ui.presenters.MainPresenter
import kotlinx.android.synthetic.main.singers_list.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch


class AllSingersFragment : Fragment(), MainPresenter.View {
    private val URL:String = "http://192.168.1.11/backend/"
    private val dataLoader= DataLoader()
    companion object {
        fun newInstance(): AllSingersFragment {
            return AllSingersFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.singers_list, container, false)
    }
    private fun showSinger(singers: Singer.List){
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


