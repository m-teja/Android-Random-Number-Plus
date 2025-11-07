package com.teja_app_productions_random_number_plus.features.diceroll

import com.teja_app_productions_random_number_plus.features.base.BaseFeatureViewModel
import com.teja_app_productions_random_number_plus.features.base.FeatureType
import com.teja_app_productions_random_number_plus.features.data.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiceRollViewModel @Inject constructor(
    private val factory: DiceRollScreenModelFactory,
    historyRepository: HistoryRepository,
) : BaseFeatureViewModel<DiceRollScreenModel, DiceRollResult>(
    featureType = FeatureType.DICE_ROLL,
    historyRepository = historyRepository,
    screenModelFactory = factory,
    initialState = factory.create()
) {
    fun generateNewNumbers() {
        val newModel = factory.generateNewNumbers(model.value)
        updateHistory(DiceRollResult(newModel.firstDie, newModel.secondDie))
        updateModel(newModel)
    }
}
