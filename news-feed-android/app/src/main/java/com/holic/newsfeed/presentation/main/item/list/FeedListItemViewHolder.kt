package com.holic.newsfeed.presentation.main.item.list

import android.view.View
import android.view.ViewGroup
import com.holic.newsfeed.R
import com.holic.newsfeed.databinding.LayoutFeedListItemBinding
import com.holic.newsfeed.presentation.common.util.ext.createView
import com.holic.newsfeed.presentation.main.item.FeedItemViewHolder


class FeedListItemViewHolder(itemView: View) :
    FeedItemViewHolder<FeedListItemViewModel, LayoutFeedListItemBinding>(itemView) {

    companion object {
        fun newInstance(parent: ViewGroup) =
            FeedListItemViewHolder(parent.createView(R.layout.layout_feed_list_item))
    }

    override fun onBind(viewModel: FeedListItemViewModel, position: Int) {
        binding?.run {
            if (this.viewModel != viewModel) {
                this.viewModel = viewModel
            }
            executePendingBindings()
        }
    }
}
