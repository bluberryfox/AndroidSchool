package app.bluberryfox.showsinger.anko

import android.content.Context
import android.view.Gravity
import app.bluberryfox.showsinger.R
import org.jetbrains.anko._FrameLayout
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.matchParent

/**
 * Created by user on 12.03.2018.
 */
class SingerListUI(context:Context):_FrameLayout(context){
    init{
        lparams(width=matchParent, height = matchParent)
        floatingActionButton{
            id = R.id.fab
            foregroundGravity = Gravity.BOTTOM

        }
    }
}