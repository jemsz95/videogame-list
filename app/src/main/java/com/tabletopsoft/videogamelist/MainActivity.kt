package com.tabletopsoft.videogamelist

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tab = R.id.navigation_home
        private set

    private lateinit var homeTabFragment: HomeTabFragment
    private lateinit var listTabFragment: ListTabFragment

    private val navigationAction = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        changeTabTo(item.itemId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeTabFragment = HomeTabFragment.newInstance()
        listTabFragment = ListTabFragment.newInstance()

        navigation.setOnNavigationItemSelectedListener(navigationAction)

        if(savedInstanceState != null) {
            tab = savedInstanceState.getInt(CURRENT_TAB)
        }

        changeTabTo(tab)
    }

    private fun changeTabTo(navItemId: Int) : Boolean {
        tab = navItemId
        return when (navItemId) {
            R.id.navigation_home -> {
                with(supportFragmentManager.beginTransaction()) {
                    replace(R.id.container, homeTabFragment)
                    commit()
                }
                true
            }
            R.id.navigation_games -> {
                TODO("Navigate to game")
                //true
            }
            R.id.navigation_list -> {
                with(supportFragmentManager.beginTransaction()) {
                    replace(R.id.container, listTabFragment)
                    commit()
                }
                true
            }
            R.id.navigation_profile -> {
                TODO("Navigate to profile")
                //true
            }
            else -> false
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putInt(CURRENT_TAB, tab)
    }

    companion object {
        private const val CURRENT_TAB = "current_tab"
    }
}
