package com.holic.newsfeed.presentation.common.util.ext

import android.view.View
import com.holic.newsfeed.presentation.common.util.DebounceClickListener

fun View.setOnDebounceClickListener(
    listener: View.OnClickListener
) {
    setOnClickListener(
        DebounceClickListener({
            listener.onClick(it)
        })
    )
}