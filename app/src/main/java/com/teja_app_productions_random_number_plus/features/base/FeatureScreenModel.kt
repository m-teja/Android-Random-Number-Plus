package com.teja_app_productions_random_number_plus.features.base

import com.teja_app_productions_random_number_plus.features.components.HistoryListModel

interface FeatureScreenModel<T> where T : FeatureScreenModel<T> {
    val history: HistoryListModel
    val showTutorial: Boolean
    fun copyWithNewHistory(history: HistoryListModel): T
}
