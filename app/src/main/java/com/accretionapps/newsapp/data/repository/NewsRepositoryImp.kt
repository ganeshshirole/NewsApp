package com.accretionapps.newsapp.data.repository

import com.accretionapps.newsapp.data.remote.NewsApiService
import com.accretionapps.newsapp.domain.model.news.News
import com.accretionapps.newsapp.domain.model.newspapers.Newspapers
import com.accretionapps.newsapp.domain.repository.NewsRepository

class NewsRepositoryImp(private val apiService: NewsApiService) : NewsRepository {

    override suspend fun getNewspapers(
        url: String
    ): Newspapers =
        apiService.getNewspapers(url = url)

    override suspend fun getNews(
        url: String
    ): News =
        apiService.getNews(url = url)
}
