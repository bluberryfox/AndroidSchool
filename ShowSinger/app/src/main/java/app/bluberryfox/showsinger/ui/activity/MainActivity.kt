package app.bluberryfox.showsinger.ui.activity

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
import app.bluberryfox.showsinger.ui.fragments.AllSingersList
import app.bluberryfox.showsinger.ui.fragments.HeardSingers

class MainActivity : AppCompatActivity() {
    private var drawerLayout: DrawerLayout? = null
    private var toolbar: Toolbar? = null
    private var nvDrawer: NavigationView? = null
    private var drawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawerToggle = setupDrawerToggle()
        drawerLayout?.addDrawerListener(drawerToggle!!);
        nvDrawer = findViewById<NavigationView>(R.id.nvView)

        setupDrawerContent(nvDrawer)
        val headerLayout = nvDrawer?.getHeaderView(0)
        selectDrawerItem(nvDrawer?.menu!!.getItem(0))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout?.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawerToggle(): ActionBarDrawerToggle {
        return ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
    }

    private fun setupDrawerContent(navigationView: NavigationView?) {
        navigationView?.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            true
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle?.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle?.onConfigurationChanged(newConfig)
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        var fragment: Fragment? = null
        when (menuItem.itemId) {
            R.id.nav_first_fragment -> {
                fragment = AllSingersList()
            }
            R.id.nav_second_fragment -> fragment = HeardSingers()
            else -> fragment = AllSingersList()
        }
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit()
        menuItem.isChecked = true
        title = menuItem.title
        drawerLayout?.closeDrawers()
    }

}
