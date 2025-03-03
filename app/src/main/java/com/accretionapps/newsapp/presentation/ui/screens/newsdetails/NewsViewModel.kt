package com.accretionapps.newsapp.presentation.ui.screens.newsdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accretionapps.newsapp.domain.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) :
    ViewModel() {

    private val _state = MutableStateFlow<NewsState>(NewsState.Loading)
    val state: StateFlow<NewsState> = _state

    fun handleIntents(intent: NewsIntent) {
        viewModelScope.launch {
            when (intent) {
                is NewsIntent.LoadNews -> fetchNews(intent.url)
            }
        }
    }

    private suspend fun fetchNews(url: String) {
        _state.value = NewsState.Loading
        getNewsUseCase(url = url).catch {
            _state.value = NewsState.Error(it.message ?: "Unknown error occurred")
        }.collect {
            _state.value = NewsState.Success(it)
        }
    }
}
