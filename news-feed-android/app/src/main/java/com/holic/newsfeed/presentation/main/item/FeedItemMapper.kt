package com.holic.newsfeed.presentation.main.item

import com.holic.newsfeed.core.model.NewsFeed
import com.holic.newsfeed.presentation.base.event.EventNotifier
import com.holic.newsfeed.presentation.main.item.list.FeedListItemViewModel

object FeedItemMapper {
    private fun getItem(
        newsFeed: NewsFeed,
        eventNotifier: EventNotifier
    ): FeedListItemViewModel = FeedListItemViewModel(
        newsFeed = newsFeed,
        eventNotifier = eventNotifier
    )

    fun getItemList(
        metaInfoList: List<NewsFeed>,
        eventNotifier: EventNotifier
    ): List<FeedListItemViewModel> {
        return metaInfoList.map { info ->
            getItem(info, eventNotifier)
        }
    }
}