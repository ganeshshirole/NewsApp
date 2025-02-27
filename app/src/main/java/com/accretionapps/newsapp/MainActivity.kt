package com.accretionapps.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.accretionapps.newsapp.presentation.theme.NewsAppTheme
import com.accretionapps.newsapp.presentation.ui.screens.newspapers.NewspapersScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                NewspapersScreen()
            }
        }
    }
}