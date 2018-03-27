package app.bluberryfox.showsinger.ui.main.favoritesingers

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.bluberryfox.showsinger.R


/**
 * Created by user on 08.03.2018.
 */
//activty use database connection
class FavoriteSingersFragment : Fragment(), FavoriteSingersContract.View {
    private var favoriteSingersPresenter = FavoriteSingersPresenter();


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.singers_heard_list, container, false)

    }

    override fun onResume() {
        super.onResume()
        favoriteSingersPresenter.attachView(this)

    }

    override fun onDestroy() {
        favoriteSingersPresenter.detachView()
        super.onDestroy()
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val list = ArrayList<Singer>()
////        val adapter = SingerListAdapter(this.context!!, list, {
////        })
////        recyclerView.adapter = adapter
//        //recyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayout.VERTICAL, false)
////

 //   }
}