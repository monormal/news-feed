package com.holic.newsfeed.presentation.common.databinding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.holic.kakaobank.assignment.presentation.common.util.GridItemSpaceDecoration
import com.holic.newsfeed.presentation.common.util.ImageUtil
import com.holic.newsfeed.presentation.common.util.ext.setOnDebounceClickListener

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImage(
        view: ImageView,
        url: String?,
    ) {
        ImageUtil.setImage(view, url)
    }

    @JvmStatic
    @BindingAdapter("onDebouncedClick")
    fun View.setOnDebouncedClick(callback: (() -> Unit)?) {
        setOnDebounceClickListener { callback?.invoke() }
    }

    @JvmStatic
    @BindingAdapter("gridSpace")
    fun RecyclerView.setGridItemDecoration(space: Float) {
        if (itemDecorationCount > 0) {
            return
        }

        addItemDecoration(
            GridItemSpaceDecoration(
                (layoutManager as GridLayoutManager).spanCount,
                space.toInt()
            )
        )
    }
}
