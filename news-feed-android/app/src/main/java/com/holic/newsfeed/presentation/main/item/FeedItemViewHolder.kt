package com.holic.newsfeed.presentation.main.item

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.holic.newsfeed.presentation.base.recyclerview.BaseBindingViewHolder
import com.holic.newsfeed.presentation.main.item.list.FeedListItemViewHolder
import com.holic.newsfeed.presentation.main.view.FeedListViewType

abstract class FeedItemViewHolder<VM : FeedItemViewModel, B : ViewDataBinding>(
    itemView: View
) : BaseBindingViewHolder<VM, B>(itemView) {

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun getViewHolder(
            parent: ViewGroup,
            viewType: FeedListViewType
        ): FeedItemViewHolder<FeedItemViewModel, ViewDataBinding> {
            return when (viewType) {
                FeedListViewType.ITEM -> FeedListItemViewHolder.newInstance(parent)
            } as FeedItemViewHolder<FeedItemViewModel, ViewDataBinding>
        }
    }
}