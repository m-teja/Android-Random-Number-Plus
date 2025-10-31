package com.teja_app_productions_random_number_plus.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme
import com.teja_app_productions_random_number_plus.navigation.NavigationController
import androidx.compose.runtime.collectAsState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navigationController = NavigationController(this)
        val viewModel: MainScreenViewModel by viewModels { MainScreenViewModelFactory(navigationController) }

        setContent {
            RandomNumberPlusTheme {
                MainScreen(
                    onNavigateToFeature = viewModel::onNavigateToFeature,
                    model = viewModel.model.collectAsState().value
                )
            }
        }
    }
}