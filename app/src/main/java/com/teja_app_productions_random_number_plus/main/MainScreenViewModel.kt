package com.teja_app_productions_random_number_plus.main

import androidx.lifecycle.ViewModel
import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.main.components.NavToFeatureButtonModel
import com.teja_app_productions_random_number_plus.navigation.NavigationController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MainScreenState(
    val navToFeatureButtonModel: NavToFeatureButtonModel
)

class MainScreenViewModel(private val navigationController: NavigationController) : ViewModel() {

    private val _model = MutableStateFlow(
        MainScreenModel(
            button = "test"
        )
    )
    val model: StateFlow<MainScreenModel> = _model.asStateFlow()

    fun onNavigateToFeature() {
        navigationController.navigateToFeature()
    }
}