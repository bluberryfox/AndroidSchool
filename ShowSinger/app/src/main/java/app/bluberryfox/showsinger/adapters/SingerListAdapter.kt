package app.bluberryfox.showsinger.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.models.Singer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.singer_items.view.*

/**
 * Created by user on 08.03.2018.
 */
class SingerListAdapter(context: Context, val singers: ArrayList<Singer>, private val singerCardClickListener: () -> Unit) : RecyclerView.Adapter<SingerListAdapter.ViewHolder>() {


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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(favoriteSinger: Singer, clickListener: () -> Unit) {
            itemView.title.text = favoriteSinger.name
            itemView.genre.text = favoriteSinger.genre
            Glide.with(itemView.context)
                    .load("http://192.168.1.11/backend/"+favoriteSinger.image)
                    .apply(RequestOptions.circleCropTransform())
                    
                    .into(itemView.thumbnail)
            Log.d("картинка не грузится","http://192.168.1.11/backend/"+favoriteSinger.image)
            itemView.card_view.setOnClickListener {
                run {
                    clickListener()
                }
            }
        }
    }
}