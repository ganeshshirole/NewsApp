package com.accretionapps.newsapp.presentation.ui.screens.newspapers

import com.accretionapps.newsapp.domain.model.newspapers.Newspaper

sealed class NewspapersState {
    data object Loading : NewspapersState()
    data class Success(val newspapers: List<Newspaper>) : NewspapersState()
    data class Error(val message: String) : NewspapersState()
}