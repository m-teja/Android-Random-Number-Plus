package com.teja_app_productions_random_number_plus.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teja_app_productions_random_number_plus.features.components.HistoryListModel
import com.teja_app_productions_random_number_plus.features.data.RemoteHistoryItemModel
import com.teja_app_productions_random_number_plus.features.data.HistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseFeatureViewModel<T : FeatureScreenModel<T>, H>(
    private val featureType: FeatureType,
    private val historyRepository: HistoryRepository,
    private val screenModelFactory: BaseScreenModelFactory<H>,
    initialState: T,
) : ViewModel() {

    private val _model = MutableStateFlow(initialState)
    val model = _model.asStateFlow()

    init {
        loadHistory()
    }

    private fun loadHistory() {
        viewModelScope.launch {
            val history: List<RemoteHistoryItemModel<H>> = historyRepository.getHistory(featureType)
            _model.update {
                val historyListModel = HistoryListModel(history.map { item ->
                        screenModelFactory.createHistoryRow(item.entry, item.timestamp)
                    }
                )
                it.copyWithNewHistory(historyListModel)
            }
        }
    }

    internal fun updateHistory(entry: H) {
        viewModelScope.launch {
            historyRepository.saveHistory(featureType, entry)
        }
    }

    fun onDeleteHistoryClicked() {
        viewModelScope.launch {
            historyRepository.deleteHistory(featureType)
            loadHistory()
        }
    }

    internal fun updateModel(newModel: T) {
        _model.update {
            newModel
        }
    }
}