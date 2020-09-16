package jp.shn.coroutine.practice

import android.app.Application
import jp.shn.coroutine.practice.di.AppComponent
import jp.shn.coroutine.practice.di.AppModule
import jp.shn.coroutine.practice.di.DaggerAppComponent

/**
 * Created by shn on 2020/09/01.
 */
class App : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }
}