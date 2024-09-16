package com.example.planetapp

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var listview:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listview = findViewById(R.id.listView)

        val planets = Planets("Mercury", "0", R.drawable.mercury)
        val planets1 = Planets("Venus", "0", R.drawable.venus)
        val planets2 = Planets("Earth", "1", R.drawable.earth)
        val planets3 = Planets("Mars", "2", R.drawable.mars)
        val planets4 = Planets("Jupiter", "79", R.drawable.jupiter)
        val planets5 = Planets("Saturn", "82", R.drawable.saturn)
        val planets6 = Planets("Uranus", "27", R.drawable.uranus)
        val planets7 = Planets("Sun", "0", R.drawable.sun)

       var planetsList = ArrayList<Planets>()
        planetsList.add(planets)
        planetsList.add(planets1)
        planetsList.add(planets2)
        planetsList.add(planets3)
        planetsList.add(planets4)
        planetsList.add(planets5)
        planetsList.add(planets6)
        planetsList.add(planets7)

        listview.adapter = CustomAdapter(this, planetsList)


//        click handler
        listview.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as Planets
//          display the planet name in toast
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }

    }
}