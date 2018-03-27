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
import app.bluberryfox.showsinger.models.Singer
import app.bluberryfox.showsinger.ui.adapters.SingerListAdapter
import app.bluberryfox.showsinger.ui.singerinfo.SingerInfo
import kotlinx.android.synthetic.main.singers_list.*


class AllSingersFragment : Fragment(), AllSingersContract.View {
    private var allSingersPresenter = AllSingersPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.singers_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        allSingersPresenter.attachView(this)
        recyclerView.layoutManager = LinearLayoutManager(view?.context, LinearLayout.VERTICAL, false)
    }
    override fun onDestroy() {
        allSingersPresenter.detachView()
        super.onDestroy()
    }

    override fun showSingers(singers: Singer.List){
        val adapter = SingerListAdapter(this.context!!, singers) {
           showSingerInfo(it)
        }
        recyclerView.adapter = adapter
    }

    override fun showSingerInfo(singer: Singer) {
        val intent = Intent(view!!.context, SingerInfo::class.java)
        intent.putExtra("singer_name", singer.name)
        startActivity(intent)
    }
}


