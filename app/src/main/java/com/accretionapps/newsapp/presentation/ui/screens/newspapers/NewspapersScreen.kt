package com.accretionapps.newsapp.presentation.ui.screens.newspapers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.accretionapps.newsapp.domain.model.newspapers.Newspaper
import com.accretionapps.newsapp.presentation.ui.components.NewspaperItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewspapersScreen(viewModel: NewspapersViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.handleIntents(NewspapersIntent.LoadNewspapers)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("News List") })
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is NewspapersState.Loading -> CircularProgressIndicator()
                is NewspapersState.Success -> NewspaperList(newspapers = (state as NewspapersState.Success).newspapers)
                is NewspapersState.Error -> Text("Error: ${(state as NewspapersState.Error).message}")
            }
        }
    }
}

@Composable
fun NewspaperList(newspapers: List<Newspaper>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(newspapers.size) { index ->
            NewspaperItem(newspapers[index])
        }
    }
}
