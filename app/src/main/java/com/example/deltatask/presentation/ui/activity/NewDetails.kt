package com.example.deltatask.presentation.ui.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.deltatask.R
import com.example.deltatask.databinding.ActivityNewDetailsBinding

class NewDetails : AppCompatActivity() {
    private lateinit var binding: ActivityNewDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val desc = intent.getStringExtra("desc")
        val author = intent.getStringExtra("author")
        val url = intent.getStringExtra("url")
        binding.newDesc.text=desc
        binding.author.text=author
        binding.readMore.setOnClickListener(View.OnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        })
    }
}