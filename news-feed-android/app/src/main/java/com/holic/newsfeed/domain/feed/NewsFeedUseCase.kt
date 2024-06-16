package com.holic.newsfeed.domain.feed

import com.holic.newsfeed.core.model.NewsFeed
import com.holic.newsfeed.data.RepositoryResult
import com.holic.newsfeed.data.respository.feed.NewsFeedRepository
import com.holic.newsfeed.domain.UseCaseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsFeedUseCase @Inject constructor(
    private val repository: NewsFeedRepository,
) {
    suspend fun execute(): UseCaseResult<List<NewsFeed>> = withContext(Dispatchers.IO) {
        return@withContext repository.fetchArticles().toUseCaseResult()
    }

    private fun RepositoryResult<List<NewsFeed>>.toUseCaseResult() =
        when (this) {
            is RepositoryResult.Error -> UseCaseResult.Error(errorMessage)
            is RepositoryResult.Exception -> UseCaseResult.Error(exception)
            is RepositoryResult.Success -> UseCaseResult.Success(data)
        }
}