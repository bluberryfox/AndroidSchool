package app.bluberryfox.showsinger.fragments

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
import kotlinx.android.synthetic.main.singers_list.*


/**
 * Created by user on 08.03.2018.
 */
class HeardSingers : Fragment(){
    //тут будут все послушанные композиции
    companion object {
        fun newInstance():HeardSingers{
            return HeardSingers()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.singers_heard_list, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<Singer>()
        prepareList(list)
        val adapter = SingerListAdapter(list, {
            //            var intent = Intent(this, SingerInfo::class.java)
//            startActivity(intent)
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(view?.context, LinearLayout.VERTICAL, false)

//        fab.setOnClickListener({
//            //            val intent = Intent(this, SingerInfo::class.java)
////            startActivity(intent)
//        }
//        )

    }
    private fun prepareList(list : ArrayList<Singer>){
        list.add(Singer("ImagineDragons", "indi", R.drawable.album1))
        list.add(Singer("Slipknot", "metal", R.drawable.album2))
        list.add(Singer("System Of A Down", "rock", R.drawable.album3))
        list.add(Singer("Daughter", "indi", R.drawable.album4))
        list.add(Singer("Twenty One Pilots", "rock", R.drawable.album5))
    }
}