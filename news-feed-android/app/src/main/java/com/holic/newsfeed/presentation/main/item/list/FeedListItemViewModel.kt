package com.holic.newsfeed.presentation.main.item.list

import androidx.databinding.ObservableBoolean
import com.holic.newsfeed.core.model.NewsFeed
import com.holic.newsfeed.presentation.base.event.EventNotifier
import com.holic.newsfeed.presentation.common.util.ext.on
import com.holic.newsfeed.presentation.main.item.FeedItemViewModel
import com.holic.newsfeed.presentation.main.model.MainAction

class FeedListItemViewModel(
    val newsFeed: NewsFeed,
    val eventNotifier: EventNotifier,
) : FeedItemViewModel {
    val isVisited = ObservableBoolean(false)

    fun clickItem() {
        isVisited.on()
        eventNotifier.notifyActionEvent(MainAction.SelectItem(this))
    }
}