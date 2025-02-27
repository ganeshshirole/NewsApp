package com.accretionapps.newsapp.presentation.ui.screens.searchnews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.accretionapps.newsapp.presentation.ui.screens.newspapers.NewspapersViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsSearchScreen(viewModel: NewspapersViewModel = hiltViewModel()) {
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
            Text(text = "Test")
        }
    }
}
