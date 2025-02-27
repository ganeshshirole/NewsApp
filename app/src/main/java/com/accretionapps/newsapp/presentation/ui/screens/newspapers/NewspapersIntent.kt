package com.accretionapps.newsapp.presentation.ui.screens.newspapers

sealed class NewspapersIntent {
    data object LoadNewspapers : NewspapersIntent()
}