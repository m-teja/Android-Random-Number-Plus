package com.teja_app_productions_random_number_plus.features.data

import com.google.gson.reflect.TypeToken
import com.teja_app_productions_random_number_plus.features.FeatureType
import com.teja_app_productions_random_number_plus.features.toHistoryKey
import com.teja_app_productions_random_number_plus.libs.preferences.PreferencesManager
import javax.inject.Inject
import javax.inject.Singleton

data class RemoteHistoryItemModel<T>(
    val entry: T,
    val timestamp: String
)

@Singleton
class LocalHistoryDataSource @Inject constructor(
    private val preferencesManager: PreferencesManager
) {
    fun <T> getHistory(featureType: FeatureType): List<RemoteHistoryItemModel<T>> {
        val remoteHistoryItemModelType = TypeToken.getParameterized(RemoteHistoryItemModel::class.java, featureType.historyType).type
        val listType = TypeToken.getParameterized(List::class.java, remoteHistoryItemModelType).type
        return preferencesManager.getHistory(featureType.toHistoryKey(), listType)
    }

    fun <T> saveHistoryList(key: String, historyList: List<T>) {
        preferencesManager.saveHistory(key, historyList)
    }
}
