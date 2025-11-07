package com.teja_app_productions_random_number_plus.features.base

import com.teja_app_productions_random_number_plus.features.components.HistoryRow

interface BaseScreenModelFactory<T> {
    fun createHistoryRow(entry: T, timeStamp: String): HistoryRow
}
