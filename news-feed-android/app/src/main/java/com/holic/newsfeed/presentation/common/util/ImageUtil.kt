package com.holic.newsfeed.presentation.common.util

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.holic.newsfeed.common.log.L

object ImageUtil {

    private fun request(view: View): RequestManager? = try {
        Glide.with(view)
    } catch (e: Exception) {
        L.e(e)
        null
    }

    private fun load(view: ImageView, string: String?): RequestBuilder<Drawable>? =
        request(view)?.load(string)


    fun setImage(view: ImageView, url: String?) {
        load(view, url)?.into(view)
    }
}