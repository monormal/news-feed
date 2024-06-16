package com.holic.newsfeed.core.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsFeed(
    val title: String,
    val url: String,
    val image: String,
    val datetime: String,
)
