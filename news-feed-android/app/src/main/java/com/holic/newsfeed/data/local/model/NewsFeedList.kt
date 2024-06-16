package com.holic.newsfeed.data.local.model

import com.holic.newsfeed.core.model.NewsFeed
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsFeedList(val list: List<NewsFeed>)
