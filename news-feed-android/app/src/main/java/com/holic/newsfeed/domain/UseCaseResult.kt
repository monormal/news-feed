package com.holic.newsfeed.domain

sealed class UseCaseResult<out T> {
    val isSuccess: Boolean
        get() = this is Success

    val isError: Boolean
        get() = this is Error

    data class Success<T>(val data: T) : UseCaseResult<T>()

    data class Error(
        val message: String? = null,
        val error: Throwable? = null
    ) : UseCaseResult<Nothing>() {
        constructor(error: Throwable?) : this(null, error)
    }
}