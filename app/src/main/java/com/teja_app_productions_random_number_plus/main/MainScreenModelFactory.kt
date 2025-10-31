package com.teja_app_productions_random_number_plus.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teja_app_productions_random_number_plus.navigation.NavigationController

class MainScreenModelFactory {
    fun create(): MainScreenModel {
        return MainScreenModel(
            listOf()
        )
    }
}