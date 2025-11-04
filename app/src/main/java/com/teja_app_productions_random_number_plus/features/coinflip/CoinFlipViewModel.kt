package com.teja_app_productions_random_number_plus.features.coinflip

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CoinFlipViewModel @Inject constructor(
    private val factory: CoinFlipScreenModelFactory
) : ViewModel() {

    private val _model = MutableStateFlow(factory.create())
    val model = _model.asStateFlow()

    fun flipCoin() {
        _model.update { factory.flip(it) }
    }
}
