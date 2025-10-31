package com.teja_app_productions_random_number_plus.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    mainScreenModelFactory: MainScreenModelFactory
) : ViewModel() {

    private val _model = MutableStateFlow(
        mainScreenModelFactory.create()
    )
    val model: StateFlow<MainScreenModel> = _model.asStateFlow()

}