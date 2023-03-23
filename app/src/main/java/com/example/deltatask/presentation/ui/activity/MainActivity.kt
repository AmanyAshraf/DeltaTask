package com.example.deltatask.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.deltatask.data.model.Articles
import com.example.deltatask.databinding.ActivityMainBinding
import com.example.deltatask.presentation.ui.adapter.NewsAdapter
import com.example.deltatask.presentation.viewmodel.NewsViewModel


class MainActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this).get(NewsViewModel::class.java) }
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NewsAdapter
    val items = mutableListOf<Articles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NewsAdapter(items.toList())
        binding.rv.setHasFixedSize(true)
        binding.rv.adapter=adapter

        viewModel.response.observe(this) {
            adapter.data=it.articles
            adapter.notifyDataSetChanged()
        }
    }
}