package com.teja_app_productions_random_number_plus.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teja_app_productions_random_number_plus.navigation.NavigationController

class MainScreenViewModelFactory(private val navigationController: NavigationController) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainScreenViewModel(navigationController) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}