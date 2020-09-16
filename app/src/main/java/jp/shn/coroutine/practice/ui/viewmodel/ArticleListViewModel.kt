package jp.shn.coroutine.practice.ui.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableArrayList
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LifecycleCoroutineScope
import jp.shn.coroutine.practice.data.Api
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by shn on 2020/09/15
 */
class ArticleListViewModel @Inject constructor(val activity: AppCompatActivity) : BaseObservable() {

    @Inject lateinit var api: Api

    @Bindable
    var articles: ObservableArrayList<Any> = ObservableArrayList()
        set(value) {
            field = value
            notifyPropertyChanged(BR.articles)
        }


    fun start(lifecycleScope: LifecycleCoroutineScope) {
        lifecycleScope.launch {
            var res = api.getArticleList()
            res?.let { articles.addAll(it) }

            Timber.d(articles.toString())
        }
    }

}