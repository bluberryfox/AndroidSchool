package csu.iit.ru.showsinger.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import csu.iit.ru.showsinger.R
import csu.iit.ru.showsinger.adapters.SingerAdapter
import csu.iit.ru.showsinger.anko.HomePageUI
import csu.iit.ru.showsinger.models.Singer
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast


class HomePageActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer: DrawerLayout
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var favoriteSinger = ArrayList<Singer>()
        favoriteSinger.add(Singer("Наадя"))
        favoriteSinger.add(Singer("Самое большое простое число"))
        favoriteSinger.add(Singer("Валентин Стрыкало"))
        favoriteSinger.add(Singer("The Matrixx"))
        HomePageUI().setContentView(this)
        val recyclerview = find<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        var adapter = SingerAdapter(favoriteSinger, { singer: Singer -> toast(singer.name) })
        recyclerview.adapter = adapter
        drawer = find<DrawerLayout>(R.id.drawer_layout)
        val toolbar = find<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        toggle.syncState()
    }
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home_page, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                toast("Settings")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_view -> toast("Поиск тут надо")
            R.id.nav_gallery -> toast("Избранное")
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
