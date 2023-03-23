package com.example.deltatask.presentation.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.deltatask.data.model.Articles

@BindingAdapter("img")
fun bindImg(imageView: ImageView, data: Articles?) {

    data?.let {
        Glide.with(imageView.context)
            .load(it.urlToImage)
            .into(imageView)
    }
}