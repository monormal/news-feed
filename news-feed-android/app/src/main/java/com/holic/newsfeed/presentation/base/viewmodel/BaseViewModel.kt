package com.holic.newsfeed.presentation.base.viewmodel

import androidx.lifecycle.ViewModel
import com.holic.newsfeed.presentation.base.event.Action
import com.holic.newsfeed.presentation.base.event.BaseEvent
import com.holic.newsfeed.presentation.base.event.EventNotifier
import com.holic.newsfeed.presentation.base.event.IBaseEvent

@Suppress("PropertyName")
abstract class BaseViewModel : ViewModel(), EventNotifier {

    protected open val _event: BaseEvent = BaseEvent()
    open val event: IBaseEvent
        get() = _event

    protected open fun handleActionEvent(action: Action) {}
    override fun notifyActionEvent(action: Action) {
        handleActionEvent(action)
        _event._action.setHandledValue(action)
    }
}
