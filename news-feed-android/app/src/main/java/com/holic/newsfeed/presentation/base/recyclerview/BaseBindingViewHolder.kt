package com.holic.newsfeed.presentation.base.recyclerview

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingViewHolder<VM : Any, B : ViewDataBinding>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    val binding: B? = DataBindingUtil.bind(itemView)

    abstract fun onBind(viewModel: VM, position: Int)
}