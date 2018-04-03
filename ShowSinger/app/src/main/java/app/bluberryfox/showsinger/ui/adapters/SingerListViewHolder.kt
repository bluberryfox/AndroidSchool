package app.bluberryfox.showsinger.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import app.bluberryfox.showsinger.data.Singer
import app.bluberryfox.showsinger.util.Constants
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.singer_items.view.*

/**
 * Created by user on 27.03.2018.
 */
class SingerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(favoriteSinger: Singer, clickListener: (Singer) -> Unit) {
        itemView.title.text = favoriteSinger.name
        itemView.genre.text = favoriteSinger.genre
        Glide.with(itemView.context)
                .load( Constants.URL + favoriteSinger.image)
                .apply(RequestOptions.circleCropTransform())
                .into(itemView.thumbnail)
        itemView.card_view.setOnClickListener {
            run {
                clickListener(favoriteSinger)
            }
        }
    }
}
