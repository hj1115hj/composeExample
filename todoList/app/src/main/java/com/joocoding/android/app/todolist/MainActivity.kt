package com.joocoding.android.app.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joocoding.android.app.todolist.domain.util.TodoAndroidViewModelFactory
import com.joocoding.android.app.todolist.ui.main.MainScreen
import com.joocoding.android.app.todolist.ui.main.MainViewModel
import com.joocoding.android.app.todolist.ui.theme.TodolistTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = viewModel(
                factory = TodoAndroidViewModelFactory(application),
            )

            MainScreen(viewModel = viewModel)
        }
    }
}

