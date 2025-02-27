package com.accretionapps.newsapp.domain.usecase

import com.accretionapps.newsapp.domain.model.news.News
import com.accretionapps.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(
        url: String
    ): Flow<News> = flow {
        val news = repository.getNews(url)
        emit(news)
    }
}
