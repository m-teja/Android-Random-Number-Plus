package com.teja_app_productions_random_number_plus.features.randomnumberpicker

import com.teja_app_productions_random_number_plus.features.FeatureScreenModel
import com.teja_app_productions_random_number_plus.features.components.HistoryListModel

const val RANDOM_NUMBER_PICKER_MIN_RANGE = 1
const val RANDOM_NUMBER_PICKER_MAX_RANGE = 100

data class RandomNumberScreenModel(
    val result: Int,
    val minRange: Int = RANDOM_NUMBER_PICKER_MIN_RANGE,
    val maxRange: Int = RANDOM_NUMBER_PICKER_MAX_RANGE,
    override val history: HistoryListModel = HistoryListModel(emptyList()),
    override val showTutorial: Boolean = false,
) : FeatureScreenModel<RandomNumberScreenModel> {
    override fun copyWithNewHistory(history: HistoryListModel): RandomNumberScreenModel {
        return this.copy(history = history)
    }
}
