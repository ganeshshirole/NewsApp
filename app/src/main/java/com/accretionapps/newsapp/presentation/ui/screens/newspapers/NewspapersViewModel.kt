package com.accretionapps.newsapp.presentation.ui.screens.newspapers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.accretionapps.newsapp.domain.usecase.GetNewsUseCase
import com.accretionapps.newsapp.domain.usecase.GetNewspapersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewspapersViewModel @Inject constructor(
    private val getNewspapersUseCase: GetNewspapersUseCase,
    private val getNewsUseCase: GetNewsUseCase
) :
    ViewModel() {

    private val _state = MutableStateFlow<NewspapersState>(NewspapersState.Loading)
    val state: StateFlow<NewspapersState> = _state

    fun handleIntents(intent: NewspapersIntent) {
        viewModelScope.launch {
            when (intent) {
                is NewspapersIntent.LoadNewspapers -> fetchNewspapers()
            }
        }
    }

    private suspend fun fetchNewspapers() {
        _state.value = NewspapersState.Loading
        getNewspapersUseCase(url = "https://chroniclingamerica.loc.gov/newspapers.json").catch {
            _state.value = NewspapersState.Error(it.message ?: "Unknown error occurred")
        }.collect {
            _state.value = NewspapersState.Success(it)
        }
    }
}
