package csu.iit.ru.showsinger.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import csu.iit.ru.showsinger.R
import csu.iit.ru.showsinger.models.Singer
import kotlinx.android.synthetic.main.singer_items.view.*

/**
 * Created by user on 26.02.2018.
 */
class HomePageAdapter(val favoriteSingers: ArrayList<Singer>) : RecyclerView.Adapter<HomePageAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        (holder as HomePageAdapter.ViewHolder).bind(favoriteSingers[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.singer_items, parent, false)
        return HomePageAdapter.ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return favoriteSingers.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(favoriteSinger: Singer) {
            itemView.singerName.text = favoriteSinger.name
        }
    }
}