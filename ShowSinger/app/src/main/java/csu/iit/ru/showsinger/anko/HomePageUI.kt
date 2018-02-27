package csu.iit.ru.showsinger.anko

import android.support.design.widget.AppBarLayout
import android.support.v4.view.GravityCompat
import android.util.TypedValue
import csu.iit.ru.showsinger.R
import csu.iit.ru.showsinger.ui.HomePageActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4._DrawerLayout
import org.jetbrains.anko.support.v4.drawerLayout

/**
 * Created by user on 27.02.2018.
 */
class HomePageUI: AnkoComponent<HomePageActivity>{
    override fun createView(ui: AnkoContext<HomePageActivity>)=with(ui) {
        drawerLayout {
            id = R.id.drawer_layout
            //?
            fitsSystemWindows = true
            createAppBar(ui)
            createNavigationView(ui)

        }
    }
    fun _DrawerLayout.createAppBar(ui: AnkoContext<HomePageActivity>){
        coordinatorLayout {
            fitsSystemWindows = true
            appBarLayout {
                toolbar {
                    id = R.id.toolbar
                    popupTheme = R.style.AppTheme_PopupOverlay
                    backgroundResource = R.color.colorPrimary
                    fitsSystemWindows=true
                }.lparams(width = matchParent) {
                    val tv = TypedValue()
                    if (ui.owner.theme.resolveAttribute(R.attr.actionBarSize, tv, true)) {
                        height = TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics);
                    }
                }
            }.lparams(width = matchParent)

            relativeLayout {
                horizontalPadding = resources.getDimensionPixelSize(R.dimen.activity_horizontal_margin)
                verticalPadding = resources.getDimensionPixelSize(R.dimen.activity_vertical_margin)
                textView("Hello World!")
            }.lparams(width = matchParent, height = matchParent) {
                behavior = AppBarLayout.ScrollingViewBehavior()
            }
        }.lparams(width = matchParent, height = matchParent)
    }
    fun _DrawerLayout.createNavigationView(ui: AnkoContext<HomePageActivity>) {
        navigationView {
            fitsSystemWindows = true
            setNavigationItemSelectedListener(ui.owner)
            inflateHeaderView(R.layout.nav_header_home_page)
            inflateMenu(R.menu.activity_home_page_drawer)
        }.lparams(height = matchParent, gravity = GravityCompat.START)
    }
}