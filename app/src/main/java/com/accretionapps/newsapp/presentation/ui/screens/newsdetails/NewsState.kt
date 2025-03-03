package com.accretionapps.newsapp.presentation.ui.screens.newsdetails

import com.accretionapps.newsapp.domain.model.news.News

sealed class NewsState {
    data object Loading : NewsState()
    data class Success(val news: News) : NewsState()
    data class Error(val message: String) : NewsState()
}