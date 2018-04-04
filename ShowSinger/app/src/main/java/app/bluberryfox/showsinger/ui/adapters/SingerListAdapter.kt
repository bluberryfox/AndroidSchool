package app.bluberryfox.showsinger.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.data.Singer

/**
 * Created by user on 08.03.2018.
 */
class SingerListAdapter(private val singers: Singer.List, private val singerCardClickListener: (Singer) -> Unit) : RecyclerView.Adapter<SingerListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingerListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.singer_items, parent, false);
        return SingerListViewHolder(view)
    }
    override fun onBindViewHolder(holder: SingerListViewHolder, position: Int) {
        holder.bind(singers[position], singerCardClickListener)
    }
    override fun getItemCount(): Int {
        return singers.size
    }
}