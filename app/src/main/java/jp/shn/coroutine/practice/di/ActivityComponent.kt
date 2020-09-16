package jp.shn.coroutine.practice.di

import androidx.appcompat.app.AppCompatActivity
import dagger.Subcomponent
import jp.gignote.android.di.FragmentModule
import jp.shn.coroutine.practice.di.scope.ActivityScope
import jp.shn.coroutine.practice.ui.activity.MainActivity

/**
 * Created by shn on 2020/09/01.
 */
@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent : FragmentComponent {
    fun inject(activity: AppCompatActivity)


    fun plus(module: FragmentModule): FragmentComponent
//    fun plus(module: ViewModule): ViewComponent
}