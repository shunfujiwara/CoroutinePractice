package jp.shn.coroutine.practice.di

import android.content.Context
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import jp.shn.coroutine.practice.R
import jp.shn.coroutine.practice.data.ApiClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by shn on 2020/09/15
 */
@Module
class ApiModule {
    companion object {
        private fun createRetrofit(client: OkHttpClient, endpoint: String): Retrofit {
            return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(endpoint)
                .build()
        }
    }

    @Singleton
    @Provides
    fun provideApiClient(context: Context, client: OkHttpClient): ApiClient {
        return createRetrofit(client, context.getString(R.string.api_endpoint)).create(
            ApiClient::class.java
        )
    }

}