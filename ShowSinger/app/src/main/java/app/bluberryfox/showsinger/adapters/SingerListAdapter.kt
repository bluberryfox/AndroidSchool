package app.bluberryfox.showsinger.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.models.Singer
import kotlinx.android.synthetic.main.singer_items.view.*

/**
 * Created by user on 08.03.2018.
 */
class SingerListAdapter(val singers: ArrayList<Singer>, private val singerCardClickListener: () -> Unit) : RecyclerView.Adapter<SingerListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        (holder as ViewHolder).bind(singers[position], singerCardClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent!!.context).inflate(R.layout.singer_items, parent, false);
        return ViewHolder(view);
    }
    override fun getItemCount(): Int {
        return singers.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(favoriteSinger: Singer, clickListener: () -> Unit) {
            itemView.title.text = favoriteSinger.name
            itemView.genre.text = "${favoriteSinger.genre} songs"
            itemView.thumbnail.setImageResource(favoriteSinger.thumbnail)
            itemView.card_view.setOnClickListener {
                run {
                    clickListener()
                }
            }

        }
    }
}