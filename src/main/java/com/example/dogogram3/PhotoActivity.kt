package com.example.dogogram3

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PhotoActivity : AppCompatActivity() {
    private val like: Int = R.drawable.ic_like_activ
    private lateinit var recyclerView: RecyclerView
    private val comentList = mutableListOf<String>()

    companion object {
        const val EXTRA_IMAGE = "ExtraUri"
        fun getStartIntent(context: Context, photo: Int) =
            Intent(context, PhotoActivity::class.java).apply {
                putExtra(EXTRA_IMAGE, photo)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        val photo = intent.getSerializableExtra(EXTRA_IMAGE)
        findViewById<ImageView>(R.id.photo_content).setImageResource(photo as Int)

        recyclerView = findViewById(R.id.recycler_view_comment)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CommentAdapter(comentList)
    }

    override fun onStart() {
        super.onStart()
        val likeButton: ImageView? = findViewById(R.id.like_button)
        val likeQuantity: TextView? = findViewById(R.id.like_quantity)
        likeButton?.setOnClickListener {
            likeButton.setImageResource(like)
            likeQuantity?.text = "636"
            likeQuantity?.setTextColor(Color.RED)

        }
    }
}

