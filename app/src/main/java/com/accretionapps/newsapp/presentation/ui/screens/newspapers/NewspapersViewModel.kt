package com.accretionapps.newsapp.presentation.ui.screens.newspapers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accretionapps.newsapp.domain.usecase.GetNewspapersUseCase
import com.accretionapps.newsapp.utils.Constants.NEWS_PAPER_URL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewspapersViewModel @Inject constructor(
    private val getNewspapersUseCase: GetNewspapersUseCase
) :
    ViewModel() {

    private val _state = MutableStateFlow<NewspapersState>(NewspapersState.Loading)
    val state: StateFlow<NewspapersState> = _state

    init {
        handleIntents(NewspapersIntent.LoadNewspapers)
    }

    fun handleIntents(intent: NewspapersIntent) {
        viewModelScope.launch {
            when (intent) {
                is NewspapersIntent.LoadNewspapers -> fetchNewspapers()
            }
        }
    }

    private suspend fun fetchNewspapers() {
        _state.value = NewspapersState.Loading
        getNewspapersUseCase(url = NEWS_PAPER_URL).catch {
            _state.value = NewspapersState.Error(it.message ?: "Unknown error occurred")
        }.collect {
            _state.value = NewspapersState.Success(it)
        }
    }
}
