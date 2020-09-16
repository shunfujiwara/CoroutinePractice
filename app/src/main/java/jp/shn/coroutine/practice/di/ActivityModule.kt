package jp.shn.coroutine.practice.di

import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 * Created by shn on 2020/09/01.
 */
@Module
class ActivityModule(val activity: AppCompatActivity) {

    @Provides
    fun activity(): AppCompatActivity {
        return activity
    }

}