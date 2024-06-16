// Origin : https://medium.com/androiddevelopers/livedata-with-snackbar-navigation-and-other-events-the-singleliveevent-case-ac2622673150

package com.holic.newsfeed.common.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class SingleLiveEvent<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content
}

/**
 * An [Observer] for [Event]s, simplifying the pattern of checking if the [Event]'s content has
 * already been handled.
 *
 * [onEventUnhandledContent] is *only* called if the [Event]'s contents has not been handled.
 */
open class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) :
    Observer<SingleLiveEvent<T>> {
    override fun onChanged(event: SingleLiveEvent<T>) {
        event.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}

class MutableLiveHandledData<T> : MutableLiveData<SingleLiveEvent<T>>() {
    fun setHandledValue(newValue: T) {
        value = SingleLiveEvent(newValue)
    }

    fun postHandledValue(newValue: T) {
        postValue(SingleLiveEvent(newValue))
    }
}

typealias LiveHandledData<T> = LiveData<SingleLiveEvent<T>>
