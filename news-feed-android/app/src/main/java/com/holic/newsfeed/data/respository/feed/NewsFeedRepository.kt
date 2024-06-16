package com.holic.newsfeed.data.respository.feed

import com.holic.newsfeed.common.ext.toFormatString
import com.holic.newsfeed.core.model.NewsFeed
import com.holic.newsfeed.data.RepositoryResult
import com.holic.newsfeed.data.local.NewsFeedStoreManager
import com.holic.newsfeed.data.remote.HeadlineApi
import com.holic.newsfeed.data.remote.model.ArticlesResponse
import javax.inject.Inject

class NewsFeedRepository @Inject constructor(
    private val apis: HeadlineApi,
    private val storeManager: NewsFeedStoreManager,
) {
    suspend fun fetchArticles(
    ): RepositoryResult<List<NewsFeed>> {

        val result = runCatching { apis.getArticles() }.getOrElse {
            return RepositoryResult.Exception(it).orLocalData()
        }

        if (result.isSuccessful && result.body() != null) {
            result.body()?.let { body ->
                return RepositoryResult.Success(
                    body.toNewsFeed().also { storeManager.put(it) })
            }
        }
        return RepositoryResult.Error(result.code(), result.message()).orLocalData()
    }

    private fun RepositoryResult<List<NewsFeed>>.orLocalData(): RepositoryResult<List<NewsFeed>> {
        val localList = storeManager.get()
        if (localList.isNotEmpty()) {
            return RepositoryResult.Success(localList)
        }
        return this
    }

    private fun ArticlesResponse?.toNewsFeed() = this?.articles?.map {
        NewsFeed(
            title = it.title.orEmpty(),
            url = it.url.orEmpty(),
            image = it.image.orEmpty(),
            datetime = it.datetime.toFormatString().orEmpty()
        )
    }.orEmpty()
}