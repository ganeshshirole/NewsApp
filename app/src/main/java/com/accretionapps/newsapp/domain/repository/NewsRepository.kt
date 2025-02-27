package com.accretionapps.newsapp.domain.repository

import com.accretionapps.newsapp.domain.model.news.News
import com.accretionapps.newsapp.domain.model.newspapers.Newspapers

interface NewsRepository {
    suspend fun getNewspapers(
        url: String
    ): Newspapers

    suspend fun getNews(
        url: String
    ): News
}