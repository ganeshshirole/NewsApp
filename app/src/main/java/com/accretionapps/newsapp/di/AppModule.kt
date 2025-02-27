package com.accretionapps.newsapp.di

import com.accretionapps.newsapp.data.remote.NewsApiService
import com.accretionapps.newsapp.data.repository.NewsRepositoryImp
import com.accretionapps.newsapp.domain.repository.NewsRepository
import com.accretionapps.newsapp.domain.usecase.GetNewsUseCase
import com.accretionapps.newsapp.domain.usecase.GetNewspapersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideService(): NewsApiService {
        return NewsApiService.create()
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: NewsApiService): NewsRepository {
        return NewsRepositoryImp(apiService)
    }

    @Provides
    @Singleton
    fun provideGetNewsUseCase(repository: NewsRepository): GetNewsUseCase {
        return GetNewsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetNewspapersUseCase(repository: NewsRepository): GetNewspapersUseCase {
        return GetNewspapersUseCase(repository)
    }
}