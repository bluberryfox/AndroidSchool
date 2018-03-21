package app.bluberryfox.showsinger.anko

import android.content.Context
import app.bluberryfox.showsinger.R
import org.jetbrains.anko._Toolbar
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.wrapContent

class ToolbarUI(context: Context):_Toolbar(context) {
    init {
        id = R.id.toolbar
        fitsSystemWindows = true
        lparams(width= matchParent, height = wrapContent)
        popupTheme = R.style.ThemeOverlay_AppCompat_Dark_ActionBar
        backgroundColor = R.color.colorPrimary
        minimumHeight = R.attr.actionBarSize
    }
}