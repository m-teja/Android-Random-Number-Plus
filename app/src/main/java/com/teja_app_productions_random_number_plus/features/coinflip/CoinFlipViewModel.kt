package com.teja_app_productions_random_number_plus.features.coinflip

import com.teja_app_productions_random_number_plus.features.base.BaseFeatureViewModel
import com.teja_app_productions_random_number_plus.features.base.FeatureType
import com.teja_app_productions_random_number_plus.features.data.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinFlipViewModel @Inject constructor(
    private val factory: CoinFlipScreenModelFactory,
    historyRepository: HistoryRepository,
) : BaseFeatureViewModel<CoinFlipScreenModel, CoinFlipResult>(
    featureType = FeatureType.COIN_FLIP,
    historyRepository = historyRepository,
    screenModelFactory = factory,
    initialState = factory.create()
) {
    fun flipCoin() {
        val newModel = factory.flip(model.value)
        updateHistory(CoinFlipResult(newModel.result))
        updateModel(newModel)
    }
}
