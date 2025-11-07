package com.teja_app_productions_random_number_plus.features.coinflip

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun CoinFlipScreenDestination(
    coinFlipViewModel: CoinFlipViewModel = hiltViewModel()
) {
    val model by coinFlipViewModel.model.collectAsState()

    CoinFlipScreen(
        model = model,
        onFlipCoin = coinFlipViewModel::flipCoin,
        onDeleteHistoryClicked = coinFlipViewModel::onDeleteHistoryClicked
    )
}
