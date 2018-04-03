package app.bluberryfox.showsinger.ui.main

import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.ui.main.allsingers.AllSingersFragment
import app.bluberryfox.showsinger.ui.main.favoritesingers.FavoriteSingersFragment
class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var nvDrawer: NavigationView
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        drawerToggle = ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close)
        drawerLayout.addDrawerListener(drawerToggle)
        nvDrawer = findViewById(R.id.nvView)
        setupDrawerContent(nvDrawer)
        if (savedInstanceState == null) selectDrawerItem(nvDrawer.menu!!.getItem(0))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawerContent(navigationView: NavigationView?) {
        navigationView?.setNavigationItemSelectedListener {
            selectDrawerItem(it)
            true
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        var fragment: Fragment? = when (menuItem.itemId) {
            R.id.nav_first_fragment -> {
                AllSingersFragment()
            }
            R.id.nav_second_fragment -> FavoriteSingersFragment()
            else -> AllSingersFragment()
        }
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit()
        menuItem.isChecked = true
        title = menuItem.title
        drawerLayout.closeDrawers()
    }

}
