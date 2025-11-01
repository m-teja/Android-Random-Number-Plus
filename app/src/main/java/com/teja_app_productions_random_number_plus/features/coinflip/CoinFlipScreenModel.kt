package com.teja_app_productions_random_number_plus.features.coinflip

import com.teja_app_productions_random_number_plus.features.FeatureScreenModel

data class CoinFlipScreenModel(
    val result: String = "",
    override val history: String = ""
) : FeatureScreenModel
