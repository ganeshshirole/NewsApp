package com.accretionapps.newsapp.domain.usecase

import com.accretionapps.newsapp.domain.model.newspapers.Newspaper
import com.accretionapps.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewspapersUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(
        url: String
    ): Flow<List<Newspaper>> = flow {
        val newspapers = repository.getNewspapers(url).newspapers
        emit(newspapers)
    }
}
