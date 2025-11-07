package com.teja_app_productions_random_number_plus.features.diceroll

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun DiceRollScreenDestination(
    diceRollViewModel: DiceRollViewModel = hiltViewModel()
) {
    val model by diceRollViewModel.model.collectAsState()

    DiceRollScreen(
        model = model,
        onGenerateNewNumbers = diceRollViewModel::generateNewNumbers,
        onDeleteHistoryClicked = diceRollViewModel::onDeleteHistoryClicked
    )
}
