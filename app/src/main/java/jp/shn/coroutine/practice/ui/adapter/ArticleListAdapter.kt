package jp.shn.coroutine.practice.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import jp.shn.coroutine.practice.R
import jp.shn.coroutine.practice.data.datamodel.ArticleModel
import jp.shn.coroutine.practice.databinding.ViewArticleRowBinding
import jp.shn.coroutine.practice.ui.adapter.holder.BindingViewHolder


/**
 * Created by shn on 2020/09/15
 */
class ArticleListAdapter(
    context: Context, list: ObservableList<Any>
) : BaseAdapter<Any, RecyclerView.ViewHolder>(context, list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BindingViewHolder<ViewArticleRowBinding>(
            parent, R.layout.view_article_row
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when ((holder as BindingViewHolder<*>).binding) {
            is ViewArticleRowBinding -> {
                (holder.binding as ViewArticleRowBinding).apply {
                    val viewModel = getItem(position) as ArticleModel
                    this.name = viewModel.title
                }
            }
        }
        holder.binding.executePendingBindings()
    }

    init {
        list.addOnListChangedCallback(object :
            ObservableList.OnListChangedCallback<ObservableList<Any>>() {
            override fun onItemRangeRemoved(
                sender: ObservableList<Any>?, positionStart: Int, itemCount: Int
            ) {
                notifyItemRangeRemoved(positionStart, itemCount)
            }

            override fun onItemRangeMoved(
                sender: ObservableList<Any>?, fromPosition: Int, toPosition: Int, itemCount: Int
            ) {
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(
                sender: ObservableList<Any>?, positionStart: Int, itemCount: Int
            ) {
                notifyItemRangeChanged(positionStart, itemCount)
            }

            override fun onItemRangeInserted(
                sender: ObservableList<Any>?, positionStart: Int, itemCount: Int
            ) {
                notifyDataSetChanged()
            }

            override fun onChanged(sender: ObservableList<Any>?) {
                notifyDataSetChanged()
            }
        })
    }
}