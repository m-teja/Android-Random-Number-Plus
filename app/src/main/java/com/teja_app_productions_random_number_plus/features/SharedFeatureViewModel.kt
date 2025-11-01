package com.teja_app_productions_random_number_plus.features

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SharedFeatureViewModel @Inject constructor() : ViewModel() {

    private val _history = MutableStateFlow("")
    val history = _history.asStateFlow()

    fun updateHistory(newHistory: String) {
        _history.value = newHistory
    }
}