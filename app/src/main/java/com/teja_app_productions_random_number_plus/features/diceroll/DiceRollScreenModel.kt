package com.teja_app_productions_random_number_plus.features.diceroll

import com.teja_app_productions_random_number_plus.features.base.FeatureScreenModel
import com.teja_app_productions_random_number_plus.features.components.HistoryListModel

data class DiceRollScreenModel(
    val firstDie: Int,
    val secondDie: Int,
    override val history: HistoryListModel = HistoryListModel(emptyList()),
    override val showTutorial: Boolean = false,
) : FeatureScreenModel<DiceRollScreenModel> {
    override fun copyWithNewHistory(history: HistoryListModel): DiceRollScreenModel {
        return this.copy(history = history)
    }
}
