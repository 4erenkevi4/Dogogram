package com.example.dogogram3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProfileAdapter(photo = photosList(),
            onClick = {
                startActivity(
                    PhotoActivity.getStartIntent(
                        context = this@MainActivity, photo = it
                    )
                )
            }
        )
    }

    private fun photosList() = mutableListOf(
        R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo11,
        R.drawable.photo12,
        R.drawable.photo13,
        R.drawable.photo7,
        R.drawable.photo5,
        R.drawable.photo6,
        R.drawable.photo7,
        R.drawable.photo8,
        R.drawable.photo9,
        R.drawable.photo8,
        R.drawable.photo9,
        R.drawable.photo10,
        R.drawable.photo11,
        R.drawable.photo12
    )

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_menu, menu)
        return true
    }
}