package com.example.navigation

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit  var drawerLayout :DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       drawerLayout = findViewById(R.id.main)

        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        functionality for the navigation drawer items
      val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                    replaceFragment(HomeFragment(), it.title.toString())
                    true
                }
                R.id.nav_gallery -> {
                    replaceFragment(GalleryFragment(), it.title.toString())
                    true
                }
                R.id.nav_slideshow -> {
                    replaceFragment(SlideshowFragment(), it.title.toString())
                    true
                }

                else -> false
            }
        }

    }

    private fun replaceFragment(fragment: Fragment , title: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_1, fragment)
        fragmentTransaction.commit()

        drawerLayout.closeDrawers()
        setTitle(title)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}