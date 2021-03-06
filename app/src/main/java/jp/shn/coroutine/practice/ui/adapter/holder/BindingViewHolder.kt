package jp.shn.coroutine.practice.ui.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


/**
 * Created by shn on 2020/09/15
 */
class BindingViewHolder<T : ViewDataBinding>(
    parent: ViewGroup, @LayoutRes layoutResId: Int
) : androidx.recyclerview.widget.RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
) {
    val binding: T = DataBindingUtil.bind(itemView)!!

}
