package com.teja_app_productions_random_number_plus.features.coinflip

import com.teja_app_productions_random_number_plus.features.FeatureHistory
import com.teja_app_productions_random_number_plus.features.FeatureScreenModel

enum class CoinFlipOutcome {
    HEADS,
    TAILS,
}

data class CoinFlipResult(val outcome: CoinFlipOutcome) : FeatureHistory

data class CoinFlipScreenModel(
    val result: CoinFlipOutcome? = null,
    override val history: List<CoinFlipResult> = emptyList(),
) : FeatureScreenModel
