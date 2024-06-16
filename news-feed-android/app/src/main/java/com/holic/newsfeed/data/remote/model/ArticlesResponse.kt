package com.holic.newsfeed.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticlesResponse(
    val articles: List<Article>? = null
)
