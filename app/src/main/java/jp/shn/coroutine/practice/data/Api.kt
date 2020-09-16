package jp.shn.coroutine.practice.data

import jp.shn.coroutine.practice.data.datamodel.ArticleModel
import okhttp3.OkHttpClient
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by shn on 2020/09/15
 */
@Singleton
class Api @Inject constructor() {
    @Inject lateinit var apiClient: ApiClient
    @Inject lateinit var okHttpClient: OkHttpClient

    suspend fun getArticleList(): List<ArticleModel>? {
        return try {
            apiClient.getArticleList(1, 10)
        } catch (e: Exception) {
            Timber.e(e)
            null
        }
    }
}