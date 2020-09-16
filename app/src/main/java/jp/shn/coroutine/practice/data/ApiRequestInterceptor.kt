package jp.shn.coroutine.practice.data

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


/**
 * Created by shn on 2020/09/15
 */
class ApiRequestInterceptor @Inject constructor() : Interceptor {

    companion object {
        private const val TOKEN = ""
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request()
            .newBuilder()

        builder.addHeader("Authorization", TOKEN)

        val request = builder.build()
        val response = chain.proceed(request)
        if (response.cacheResponse() != null) {
            // from cache
//            Timber.d("is cache")
        } else if (response.networkResponse() != null) {
            // from network
//            Timber.d("is network")
        }
        return response
    }
}
