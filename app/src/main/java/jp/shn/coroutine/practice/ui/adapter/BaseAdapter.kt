package jp.shn.coroutine.practice.ui.adapter

import android.content.Context
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList


/**
 * Created by shn on 2020/09/15
 */
abstract class BaseAdapter<T, VH : androidx.recyclerview.widget.RecyclerView.ViewHolder> @JvmOverloads constructor(
    internal val context: Context, protected val list: ObservableList<T> = ObservableArrayList<T>()
) : androidx.recyclerview.widget.RecyclerView.Adapter<VH>() {

    protected var recyclerView: androidx.recyclerview.widget.RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: androidx.recyclerview.widget.RecyclerView) {
        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: androidx.recyclerview.widget.RecyclerView) {
        this.recyclerView = null
    }

    fun reset(items: Collection<T>) {
        clear()
        addAll(items)
        notifyDataSetChanged()
    }

    open fun clear() {
        list.clear()
    }

    open fun addAll(items: Collection<T>) {
        list.addAll(items)
    }

    fun addAll(pos: Int, items: Collection<T>) {
        list.addAll(pos, items)
    }

    open fun addItem(item: T) {
        list.add(item)
    }

    open fun addItem(index: Int, item: T) {
        list.add(index, item)
    }

    open fun getItem(pos: Int): T {
        return list.get(pos)
    }

    fun addAllWithNotify(items: Collection<T>) {
        val pos = itemCount
        addAll(items)
        notifyItemInserted(pos)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getContext(): Context {
        return context;
    }

    fun removeItem(element: T) {
        list.remove(element)
    }

    fun getItemList() = list
}
