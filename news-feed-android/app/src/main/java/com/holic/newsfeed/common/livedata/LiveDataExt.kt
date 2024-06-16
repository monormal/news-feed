package com.holic.newsfeed.common.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LiveData<T>.observeNonNull(
    owner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) {
    this.observe(owner) {
        if (it != null) {
            observer(it)
        }
    }
}

inline fun <T> LifecycleOwner.observeNonNull(
    data: LiveData<T>,
    crossinline observer: (T) -> Unit
) {
    data.observeNonNull(this, observer)
}

fun <T> LifecycleOwner.observeNonNull(
    data: LiveData<SingleLiveEvent<T>>,
    observer: (EventObserver<T>)
) {
    data.observe(this, observer)
}

inline fun <T> LifecycleOwner.observeHandledEvent(
    data: LiveData<SingleLiveEvent<T>>,
    crossinline observer: (T) -> Unit
) {
    data.observe(this, Observer {
        it?.getContentIfNotHandled()?.let { value ->
            observer(value)
        }
    })
}

inline fun <T> LifecycleOwner.observeUnHandledEvent(
    data: LiveData<SingleLiveEvent<T>>,
    crossinline observer: (T) -> Unit
) {
    data.observe(this, Observer {
        it?.peekContent()?.let { value ->
            observer(value)
        }
    })
}
