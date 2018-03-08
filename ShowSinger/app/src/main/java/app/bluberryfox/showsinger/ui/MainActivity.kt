package app.bluberryfox.showsinger.ui

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.LinearLayout
import app.bluberryfox.showsinger.R
import app.bluberryfox.showsinger.adapters.SingerListAdapter
import app.bluberryfox.showsinger.fragments.*
import app.bluberryfox.showsinger.models.Singer
import java.util.*


class MainActivity : AppCompatActivity() {

    private var drawerLayout:DrawerLayout?=null
    private var toolbar: Toolbar?=null
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
        val headerLayout = nvDrawer?.getHeaderView(0)
        val list = ArrayList<Singer>()
        prepareList(list)
        val rView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = SingerListAdapter(list, {
            var intent = Intent(this, SingerInfo::class.java)
            startActivity(intent)
        })
        rView.adapter = adapter
        rView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val float_button = findViewById<FloatingActionButton>(R.id.fab)
        float_button.setOnClickListener({
            val intent = Intent(this, SingerInfo::class.java)
            startActivity(intent)
        }
        )



    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean{
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

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            true
        }
    }
    // `onPostCreate` вызывается при завершении запуска activity после
// `onStart()`

    // ПРИМЕЧАНИЕ 1: Не забудьте переопределить метод при помощи
    // только одного аргумента `Bundle`

    // ПРИМЕЧАНИЕ 2: Убедитесь, что вы реализуете соответствующий метод `onPostCreate(Bundle savedInstanceState)`.

    // Есть две сигнатуры и только `onPostCreate(Bundle state)`
    // показывает иконку гамбургера.
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        // Синхронизировать состояние переключения после того, как
        // возникнет onRestoreInstanceState
        drawerToggle?.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // Передать любые изменения конфигурации переключателям
        // drawer'а
        drawerToggle?.onConfigurationChanged(newConfig)
    }


    fun selectDrawerItem(menuItem: MenuItem) {
        // Создать новый фрагмент и задать фрагмент для отображения
        // на основе нажатия на элемент навигации
        var fragment: Fragment? = null
        when (menuItem.itemId) {
            R.id.nav_first_fragment ->  AllSingersList::class.java
            R.id.nav_second_fragment -> HeardSingers::class.java
        }


        // Вставить фрагмент, заменяя любой существующий
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit()

        // Выделение существующего элемента выполнено с помощью
        // NavigationView
        menuItem.isChecked = true
        // Установить заголовок для action bar'а
        title = menuItem.title
        // Закрыть navigation drawer
        drawerLayout?.closeDrawers()
    }
    private fun prepareList(list : ArrayList<Singer>){
        list.add(Singer("ImagineDragons", "indi", R.drawable.album1))
        list.add(Singer("Slipknot", "metal", R.drawable.album2))
        list.add(Singer("System Of A Down", "rock", R.drawable.album3))
        list.add(Singer("Daughter", "indi", R.drawable.album4))
        list.add(Singer("Twenty One Pilots", "rock", R.drawable.album5))
    }

}
