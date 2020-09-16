package jp.shn.coroutine.practice.di

import dagger.Subcomponent
import jp.gignote.android.di.FragmentModule

import jp.shn.coroutine.practice.di.scope.FragmentScope
import jp.shn.coroutine.practice.ui.fragment.ArticleListFragment
import jp.shn.coroutine.practice.ui.fragment.SecondFragment

/**
 * Created by shn on 2020/09/01.
 */
@FragmentScope
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {
    fun inject(fragment: ArticleListFragment)
    fun inject(fragment: SecondFragment)

}