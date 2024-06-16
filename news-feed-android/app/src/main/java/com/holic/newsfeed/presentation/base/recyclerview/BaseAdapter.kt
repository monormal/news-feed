package com.holic.newsfeed.presentation.base.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VT : Enum<VT>, VM : IViewTypeGetter<VT>> :
    RecyclerView.Adapter<BaseBindingViewHolder<VM, ViewDataBinding>>() {

    val list: ArrayList<VM> = ArrayList()

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(
        viewHolder: BaseBindingViewHolder<VM, ViewDataBinding>,
        position: Int
    ) {
        list.getOrNull(position)?.let {
            viewHolder.onBind(it, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].getViewTypeOrdinal()
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    fun addAll(items: List<VM>) {
        if (items.isEmpty()) return

        val count = itemCount
        list.addAll(items)
        notifyItemRangeInserted(count, items.size)
    }

    fun getItem(index: Int): VM? = list.getOrNull(index)
}
