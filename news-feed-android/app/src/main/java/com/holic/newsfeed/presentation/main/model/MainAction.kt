package com.holic.newsfeed.presentation.main.model

import com.holic.newsfeed.presentation.base.event.Action
import com.holic.newsfeed.presentation.main.item.list.FeedListItemViewModel

sealed class MainAction : Action() {
    class UpdateList(val itemList: List<FeedListItemViewModel>) : MainAction()
    class SelectItem(val item: FeedListItemViewModel) : MainAction()
}