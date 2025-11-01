package com.teja_app_productions_random_number_plus.features.coinflip

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.teja_app_productions_random_number_plus.features.SharedFeatureViewModel

@Composable
fun CoinFlipScreenDestination(
    sharedViewModel: SharedFeatureViewModel = hiltViewModel(),
    coinFlipViewModel: CoinFlipViewModel = hiltViewModel()
) {
    val model by coinFlipViewModel.model.collectAsState()

    LaunchedEffect(model.history) {
        sharedViewModel.updateHistory(model.history)
    }

    CoinFlipScreen(
        model = model,
        onFlipCoin = coinFlipViewModel::flipCoin
    )
}