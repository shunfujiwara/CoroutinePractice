package jp.shn.coroutine.practice.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by shn on 2020/09/01.
 */
@Module
class AppModule(val app: Application) {

    @Provides
    fun provideContext(): Context {
        return app
    }
}