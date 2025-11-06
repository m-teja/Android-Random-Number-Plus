package com.teja_app_productions_random_number_plus.features.data

import com.teja_app_productions_random_number_plus.features.FeatureType
import com.teja_app_productions_random_number_plus.features.toHistoryKey
import com.teja_app_productions_random_number_plus.libs.date.DateProvider
import javax.inject.Inject

private const val MAX_HISTORY_SIZE = 20

class HistoryRepository @Inject constructor(
    private val localHistoryDataSource: LocalHistoryDataSource,
    private val dateProvider: DateProvider
) {
    fun <T> getHistory(featureType: FeatureType): List<RemoteHistoryItemModel<T>> {
        return localHistoryDataSource.getHistory<T>(featureType).take(MAX_HISTORY_SIZE)
    }

    fun <T> saveHistory(featureType: FeatureType, entry: T) {
        val history = getHistory<T>(featureType).toMutableList()
        history.add(0, RemoteHistoryItemModel(entry, dateProvider.getFormattedTimestamp()))
        localHistoryDataSource.saveHistoryList(featureType.toHistoryKey(), history.take(MAX_HISTORY_SIZE))
    }
}
