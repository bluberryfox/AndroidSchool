package app.bluberryfox.showsinger.anko

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import app.bluberryfox.showsinger.R
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4.drawerLayout

/**
 * Created by user on 12.03.2018.
 */
class DrawerLayoutUI(context: Context): _LinearLayout(context){
    init {
        fitsSystemWindows = true
        orientation = LinearLayout.VERTICAL
        lparams(width = matchParent, height= matchParent)
        ankoView(::ToolbarUI, 0){
        }.lparams(width = matchParent, height= wrapContent)

        drawerLayout {
            id = R.id.drawer_layout
            linearLayout{
                orientation = LinearLayout.VERTICAL
                frameLayout {
                    id=R.id.flContent

                }.lparams(width= matchParent, height= matchParent)
            }.lparams(width=matchParent, height=matchParent)

        }.lparams(width= matchParent, height= matchParent)

        navigationView {
            id=R.id.nvView
            gravity = Gravity.START
            backgroundColor = Color.WHITE
            inflateMenu(R.menu.drawer_view)
        }.lparams(width= wrapContent, height= matchParent)

    }
}