package com.vahitkeskin.kotlinfootballapp.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.downloadFromUrl(url: String?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions.placeholderOf(progressDrawable)
    Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)
}

@BindingAdapter("android:ivHuaweiUrl")
fun downloadImage(view: ImageView, url: String?) {
    view.downloadFromUrl(url, placeHolderProgressBar(view.context))
}

fun placeHolderProgressBar(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}