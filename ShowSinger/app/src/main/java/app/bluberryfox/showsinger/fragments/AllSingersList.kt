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
import kotlinx.android.synthetic.main.singers_list.*


class AllSingersList : Fragment(){
    //provides a methos for creating new instances of fragments
    companion object {
        fun newInstance():AllSingersList{
            return AllSingersList()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.singers_list, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<Singer>()
        prepareList(list)
        val adapter = SingerListAdapter(list, {
            val intent = Intent(view!!.context, SingerInfo::class.java)
            startActivity(intent)
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(view?.context, LinearLayout.VERTICAL, false)

        fab.setOnClickListener({
            val intent = Intent(view!!.context, SingerInfo::class.java)
            startActivity(intent)
        }
        )

    }
    private fun prepareList(list : ArrayList<Singer>){
        list.add(Singer("ImagineDragons", "indi", R.drawable.album1))
        list.add(Singer("Slipknot", "metal", R.drawable.album2))
        list.add(Singer("System Of A Down", "rock", R.drawable.album3))
        list.add(Singer("Daughter", "indi", R.drawable.album4))
        list.add(Singer("Twenty One Pilots", "rock", R.drawable.album5))
    }

}