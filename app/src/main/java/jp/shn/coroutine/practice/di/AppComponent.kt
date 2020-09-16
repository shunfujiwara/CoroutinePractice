package jp.shn.coroutine.practice.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import jp.shn.coroutine.practice.App
import javax.inject.Singleton

/**
 * Created by shn on 2020/09/01.
 */
@Singleton
@Component(modules = [AndroidModule::class, NetworkModule::class, ApiModule::class, AppModule::class])
interface AppComponent {

//    @Component.Builder
//    interface Builder {
//        @BindsInstance fun application(application: Application): Builder
//        fun build(): AppComponent
//    }

    fun inject(application: App)

    fun plus(module: ActivityModule): ActivityComponent
}