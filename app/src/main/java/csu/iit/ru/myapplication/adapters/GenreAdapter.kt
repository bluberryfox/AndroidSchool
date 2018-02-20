package csu.iit.ru.myapplication.adapters

/**
 * Created by user on 10.02.2018.
 */

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import csu.iit.ru.myapplication.R
import csu.iit.ru.myapplication.models.GenreInfo

class GenreAdapter(var genresList: ArrayList<GenreInfo>) : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.genres?.text = genresList[position].name
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.genre_item_recycler_view, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return genresList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val genres = itemView.findViewById<TextView>(R.id.genre)
    }

}