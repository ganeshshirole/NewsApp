package com.accretionapps.newsapp.presentation.ui.screens.newsdetails

sealed class NewsIntent {
    data class LoadNews(val url: String) : NewsIntent()
}