package com.holic.newsfeed.data

sealed class RepositoryResult<out T> {
    data class Success<out T>(val data: T) : RepositoryResult<T>()
    data class Error(val code: Int, val message: String?) : RepositoryResult<Nothing>() {
        val errorMessage = if (message.isNullOrEmpty()) "Network Error Code = $code" else message
    }

    data class Exception(val exception: Throwable) : RepositoryResult<Nothing>()
}