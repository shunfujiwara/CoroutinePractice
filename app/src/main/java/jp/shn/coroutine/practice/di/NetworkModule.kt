package jp.shn.coroutine.practice.di

import android.content.Context
import dagger.Module
import dagger.Provides
import jp.shn.coroutine.practice.BuildConfig
import jp.shn.coroutine.practice.data.ApiRequestInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created by shn on 2020/09/15
 */

@Module
class NetworkModule {

    companion object {
        val MAX_CACHE_SIZE = 5 * 1024 * 1024
    }

    @Singleton
    @Provides
    fun provideHttpClient(
        context: Context, interceptor: ApiRequestInterceptor
    ): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder()
            .cache(
                Cache(context.cacheDir, MAX_CACHE_SIZE.toLong())
            )
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(logging)
            .build()
    }
}
