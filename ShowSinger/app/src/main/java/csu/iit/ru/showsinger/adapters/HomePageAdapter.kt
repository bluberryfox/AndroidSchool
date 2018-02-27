package csu.iit.ru.showsinger.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import csu.iit.ru.showsinger.R
import csu.iit.ru.showsinger.models.Singer
import kotlinx.android.synthetic.main.singer_items.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by user on 26.02.2018.
 */
class HomePageAdapter(val favoriteSingers: ArrayList<Singer>, val clickListener: (Singer) -> Unit) : RecyclerView.Adapter<HomePageAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        (holder as HomePageAdapter.ViewHolder).bind(favoriteSingers[position], clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LunchCardUI().createView(AnkoContext.create(parent!!.context, parent)))
    }


    override fun getItemCount(): Int {
        return favoriteSingers.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(favoriteSinger: Singer, clickListener: (Singer) -> Unit) {
            itemView.singerName.text = favoriteSinger.name
        }
    }
    class LunchCardUI:AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>)=with(ui) {
            linearLayout{
                cardView{
                    linearLayout{
                        padding = 10 //px
                        orientation = LinearLayout.VERTICAL
                        textView {
                            id = R.id.singerName
                            text = "Name"
                            //android:textAppearance = @style/Base.TextAppearance.AppCompat.Large //not support attribute
                        }.lparams(width = matchParent)
                    }.lparams(width = matchParent)
                }.lparams(width = matchParent) {
                    margin = dip(5)
                }


            }
        }
    }

}