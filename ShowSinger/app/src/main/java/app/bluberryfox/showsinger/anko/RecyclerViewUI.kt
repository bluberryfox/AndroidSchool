package app.bluberryfox.showsinger.anko

import android.content.Context
import app.bluberryfox.showsinger.R
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7._RecyclerView

/**
 * Created by user on 12.03.2018.
 */
class RecyclerViewUI(context:Context):_RecyclerView(context){
    init{
        id = R.id.recyclerView
        lparams(width = matchParent, height= matchParent)

    }
}