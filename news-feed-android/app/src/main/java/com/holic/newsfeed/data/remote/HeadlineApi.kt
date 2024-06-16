package com.holic.newsfeed.data.remote

import com.holic.newsfeed.common.Property
import com.holic.newsfeed.data.remote.model.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadlineApi {
    @GET("/v2/top-headlines")
    suspend fun getArticles(
        @Query("country") country: String = Property.Api.COUNTRY_KEY,
        @Query("apiKey") apiKey: String = Property.Api.API_KEY,
    ): Response<ArticlesResponse>
}