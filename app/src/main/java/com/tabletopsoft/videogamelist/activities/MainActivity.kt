package com.tabletopsoft.videogamelist.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.tabletopsoft.videogamelist.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host)

        bottomNav.setupWithNavController(navController)

        bottomNav.setOnNavigationItemReselectedListener {
            it.onNavDestinationSelected(navController)
        }
    }
}
