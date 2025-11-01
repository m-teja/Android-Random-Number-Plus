package com.teja_app_productions_random_number_plus.features.coinflip

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class CoinFlipViewModel @Inject constructor() : ViewModel() {

    private val _model = MutableStateFlow(CoinFlipScreenModel())
    val model = _model.asStateFlow()

    fun flipCoin() {
        val result = if (Random.nextBoolean()) "Heads" else "Tails"
        _model.update {
            it.copy(
                result = result,
                history = it.history + "\n" + result
            )
        }
    }
}
