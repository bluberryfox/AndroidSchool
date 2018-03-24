package app.bluberryfox.showsinger.anko

import android.content.Context
import org.jetbrains.anko._FrameLayout
import org.jetbrains.anko.matchParent

/**
 * Created by user on 12.03.2018.
 */
class SingerListUI(context:Context):_FrameLayout(context){
    init{
        lparams(width=matchParent, height = matchParent)
    }
}