package com.teja_app_productions_random_number_plus.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme
import com.teja_app_productions_random_number_plus.navigation.NavigationController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationController: NavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RandomNumberPlusTheme {
                MainScreenDestination()
            }
        }
    }

    @Composable
    fun MainScreenDestination(
        viewModel: MainScreenViewModel = hiltViewModel()
    ) {
        MainScreen(
            onNavigateToFeature = navigationController::navigateToFeature,
            model = viewModel.model.collectAsState().value
        )
    }
}