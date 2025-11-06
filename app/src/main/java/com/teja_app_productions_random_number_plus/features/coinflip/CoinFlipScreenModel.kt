package com.teja_app_productions_random_number_plus.features.coinflip

import com.teja_app_productions_random_number_plus.features.FeatureScreenModel
import com.teja_app_productions_random_number_plus.features.components.HistoryListModel

enum class CoinFlipOutcome {
    HEADS,
    TAILS,
}

data class CoinFlipResult(val outcome: CoinFlipOutcome)

data class CoinFlipScreenModel(
    val result: CoinFlipOutcome,
    override val history: HistoryListModel = HistoryListModel(emptyList()),
    override val showTutorial: Boolean = false,
) : FeatureScreenModel<CoinFlipScreenModel> {
    override fun copyWithNewHistory(history: HistoryListModel): CoinFlipScreenModel {
        return this.copy(history = history)
    }
}
