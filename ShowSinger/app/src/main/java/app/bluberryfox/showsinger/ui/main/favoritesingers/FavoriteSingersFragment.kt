package app.bluberryfox.showsinger.ui.main.favoritesingers

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.data.Singer
import app.bluberryfox.showsinger.ui.adapters.SingerListAdapter
import app.bluberryfox.showsinger.ui.singerinfo.SingerInfoActivity
import kotlinx.android.synthetic.main.singers_list.*


/**
 * Created by user on 08.03.2018.
 */
//activty use database connection
class FavoriteSingersFragment : Fragment(), FavoriteSingersContract.View {
    override fun showSingerInfo(singer: Singer) {
        val intent = Intent(view!!.context, SingerInfoActivity::class.java)
        intent.putExtra("singer_name", singer.name)
        intent.putExtra("genre", singer.genre)
        intent.putExtra("id", singer.id)
        intent.putExtra("image", singer.image)
        startActivity(intent)
    }

    private var favoriteSingersPresenter: FavoriteSingersPresenter? = null
    override fun showFavoriteSingers(singers: Singer.List) {
        val adapter = SingerListAdapter(singers) {
            showSingerInfo(it)
        }
        recyclerView.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        favoriteSingersPresenter = FavoriteSingersPresenter(this.context!!, activity?.application as App)
        return inflater.inflate(R.layout.singers_heard_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        favoriteSingersPresenter?.attachView(this)
    }

    override fun onDestroy() {
        favoriteSingersPresenter?.detachView()
        super.onDestroy()
    }

}