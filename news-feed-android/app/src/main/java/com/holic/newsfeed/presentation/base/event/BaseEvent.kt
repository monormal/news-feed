package com.holic.newsfeed.presentation.base.event

import com.holic.newsfeed.common.livedata.LiveHandledData
import com.holic.newsfeed.common.livedata.MutableLiveHandledData

interface IBaseEvent {
    val action: LiveHandledData<Action>
}


@Suppress("PropertyName")
open class BaseEvent : IBaseEvent {
    val _action: MutableLiveHandledData<Action> by lazy { MutableLiveHandledData() }
    override var action: LiveHandledData<Action> = _action
}
