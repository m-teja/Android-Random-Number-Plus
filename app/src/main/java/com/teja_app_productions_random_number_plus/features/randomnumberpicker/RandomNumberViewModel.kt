package com.teja_app_productions_random_number_plus.features.randomnumberpicker

import com.teja_app_productions_random_number_plus.features.BaseFeatureViewModel
import com.teja_app_productions_random_number_plus.features.FeatureType
import com.teja_app_productions_random_number_plus.features.data.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RandomNumberViewModel @Inject constructor(
    private val factory: RandomNumberScreenModelFactory,
    historyRepository: HistoryRepository,
) : BaseFeatureViewModel<RandomNumberScreenModel, RandomNumberResult>(
    featureType = FeatureType.RANDOM_NUMBER,
    historyRepository = historyRepository,
    screenModelFactory = factory,
    initialState = factory.create()
) {
    fun generateNewNumber() {
        val newModel = factory.generateNewNumber(model.value)
        updateHistory(RandomNumberResult(newModel.result, newModel.minRange, newModel.maxRange))
        updateModel(newModel)
    }

    fun onMinRangeChanged(newMin: Int) {
        val newModel = factory.updateMinRange(model.value, newMin)
        updateModel(newModel)
    }

    fun onMaxRangeChanged(newMax: Int) {
        val newModel = factory.updateMaxRange(model.value, newMax)
        updateModel(newModel)
    }
}
