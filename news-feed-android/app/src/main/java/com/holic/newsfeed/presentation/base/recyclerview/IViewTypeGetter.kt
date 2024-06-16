package com.holic.newsfeed.presentation.base.recyclerview

interface IViewTypeGetter<VT : Enum<VT>> {
    fun getViewType(): VT

    fun getViewTypeOrdinal(): Int {
        return getViewType().ordinal
    }

    fun getViewTypeName(): String {
        return getViewType().name
    }
}
