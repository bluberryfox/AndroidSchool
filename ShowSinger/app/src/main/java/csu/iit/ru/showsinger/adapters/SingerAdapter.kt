package csu.iit.ru.showsinger.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import csu.iit.ru.showsinger.R
import csu.iit.ru.showsinger.models.Singer
import kotlinx.android.synthetic.main.singer_items.view.*

/**
 * Created by user on 22.02.2018.
 */
class SingerAdapter(val singers: ArrayList<Singer>, val clickListener: (Singer) -> Unit): RecyclerView.Adapter<SingerAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        (holder as ViewHolder).bind(singers[position], clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.singer_items, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return singers.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(singer: Singer, clickListener: (Singer) -> Unit) {
            itemView.title.text = singer.name
            itemView.count.text = "${singer.numOfSongs} songs"
            itemView.thumbnail.setImageResource(singer.thumbnail)
            itemView.setOnClickListener {
                clickListener(singer)
            }
        }
    }
}