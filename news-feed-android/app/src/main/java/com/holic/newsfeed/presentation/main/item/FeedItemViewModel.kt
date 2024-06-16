package com.holic.newsfeed.presentation.main.item

import com.holic.newsfeed.presentation.base.recyclerview.IViewTypeGetter
import com.holic.newsfeed.presentation.main.view.FeedListViewType


interface FeedItemViewModel : IViewTypeGetter<FeedListViewType> {
    override fun getViewType(): FeedListViewType {
        return FeedListViewType.ITEM
    }
}
