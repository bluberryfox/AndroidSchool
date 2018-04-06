package app.bluberryfox.showsinger.ui.main.allsingers

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.data.Singer
import app.bluberryfox.showsinger.ui.adapters.SingerListAdapter
import app.bluberryfox.showsinger.ui.singerinfo.SingerInfoActivity
import kotlinx.android.synthetic.main.singers_list.*


class AllSingersFragment : Fragment(), AllSingersContract.View {

    var allSingersPresenter: AllSingersPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        allSingersPresenter = AllSingersPresenter(this.context!!, activity?.application as App)
        val rootView = inflater.inflate(R.layout.singers_list, container, false)
        rootView.findViewById<SwipeRefreshLayout>(R.id.swipe).apply {
            setColorSchemeResources(R.color.colorPrimaryDark, R.color.colorPrimary, R.color.colorAccent)
            setOnRefreshListener({
                isRefreshing = false
                allSingersPresenter?.loadSingers()
            })
        }
        return rootView
    }

    override fun onResume() {
        super.onResume()
        allSingersPresenter?.attachView(this)
        recyclerView.layoutManager = LinearLayoutManager(view?.context, LinearLayout.VERTICAL, false)
    }

    override fun onDestroy() {
        allSingersPresenter?.detachView()
        super.onDestroy()
    }

    override fun showSingers(singers: Singer.List) {
        val adapter = SingerListAdapter(singers) {
            showSingerInfo(it)
        }
        recyclerView.adapter = adapter
    }

    override fun showSingerInfo(singer: Singer) {
        val intent = Intent(view!!.context, SingerInfoActivity::class.java)
        intent.putExtra("singer_name", singer.name)
        intent.putExtra("genre", singer.genre)
        intent.putExtra("id", singer.id)
        intent.putExtra("image", singer.image)
        startActivity(intent)
    }
}


