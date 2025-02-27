package com.accretionapps.newsapp.data.remote

import com.accretionapps.newsapp.domain.model.news.News
import com.accretionapps.newsapp.domain.model.newspapers.Newspapers
import com.accretionapps.newsapp.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsApiService {

    @GET
    suspend fun getNewspapers(@Url url: String): Newspapers

    @GET
    suspend fun getNews(@Url url: String): News

    companion object {

        fun create(): NewsApiService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            val client = OkHttpClient.Builder().addInterceptor(logger).build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL) // Change base URL
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(NewsApiService::class.java)
        }
    }
}
