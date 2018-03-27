package app.bluberryfox.showsinger.ui.main.favoritesingers

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.models.Singer


/**
 * Created by user on 08.03.2018.
 */
class FavoriteSingersFragment : Fragment() {
    companion object {
        fun newInstance(): FavoriteSingersFragment {
            return FavoriteSingersFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.singers_heard_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<Singer>()
//        val adapter = SingerListAdapter(this.context!!, list, {
//        })
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayout.VERTICAL, false)

    }
}