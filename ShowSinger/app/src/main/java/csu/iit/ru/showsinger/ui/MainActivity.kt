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
import android.view.View
import android.widget.LinearLayout
import csu.iit.ru.showsinger.R
import csu.iit.ru.showsinger.adapters.SingerListAdapter
import csu.iit.ru.showsinger.anko.NavigationDrawerUI
import csu.iit.ru.showsinger.models.Singer
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {

        //какой-то дикий и странный костыль для статус бара. Не трогать, без него не работает
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        super.onCreate(savedInstanceState)

        //заполнение списка
        var list = ArrayList<Singer>()
        list.add(Singer("What is", 2, R.drawable.album1))
        list.add(Singer("No No", 2, R.drawable.album2))
        list.add(Singer("Going on", 2, R.drawable.album3))
        list.add(Singer("Keep it up", 2, R.drawable.album4))
        list.add(Singer("Don't say", 2, R.drawable.album5))
        list.add(Singer("What is", 2, R.drawable.album6))
        list.add(Singer("No No", 2, R.drawable.album7))
        list.add(Singer("Going on", 2, R.drawable.album8))
        list.add(Singer("Keep it up", 2, R.drawable.album9))
        list.add(Singer("Don't say", 2, R.drawable.album10))

        //ставим layout
        NavigationDrawerUI().setContentView(this)
        //Заполняем адаптер
        val recycler = find<RecyclerView>(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        var adapter = SingerListAdapter(list, {
            run {
//                val intent = Intent(this, GenresActivity::class.java)
//                startActivity(intent)
            }
        })
        recycler.adapter = adapter
        //какой-то треш с navigationview
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
