package jp.shn.coroutine.practice.data

import jp.shn.coroutine.practice.data.datamodel.ArticleModel
import retrofit2.http.GET
import retrofit2.http.Query


/**®
 * Created by shn on 2020/09/15
 */
interface ApiClient {

    @GET("api/v2/items")
    suspend fun getArticleList(
        @Query(
            "page"
        ) page: Int,
        @Query(
            "per_page"
        ) perPage: Int
    ): List<ArticleModel>

}
