package com.holic.newsfeed.presentation.main.view

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.holic.newsfeed.presentation.base.recyclerview.BaseAdapter
import com.holic.newsfeed.presentation.base.recyclerview.BaseBindingViewHolder
import com.holic.newsfeed.presentation.main.item.FeedItemViewHolder
import com.holic.newsfeed.presentation.main.item.FeedItemViewModel

class FeedListAdapter : BaseAdapter<FeedListViewType, FeedItemViewModel>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseBindingViewHolder<FeedItemViewModel, ViewDataBinding> {
        return FeedItemViewHolder.getViewHolder(
            parent,
            FeedListViewType.entries[viewType]
        )
    }
}

enum class FeedListViewType {
    ITEM,
}