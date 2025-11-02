package com.teja_app_productions_random_number_plus.features

import androidx.lifecycle.ViewModel
import com.teja_app_productions_random_number_plus.libs.preferences.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SharedFeatureViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {

    private val _history = MutableStateFlow<List<FeatureHistory>>(emptyList())
    val history = _history.asStateFlow()

    private var currentFeatureType: FeatureType? = null

    fun loadFeature(featureType: FeatureType) {
        currentFeatureType = featureType
        _history.value = preferencesManager.getHistory(featureType.toHistoryKey(), featureType.historyType)
    }

    fun updateHistory(newHistory: List<FeatureHistory>) {
        currentFeatureType?.let { featureType ->
            _history.value = newHistory
            preferencesManager.saveHistory(featureType.toHistoryKey(), newHistory)
        }
    }
}
