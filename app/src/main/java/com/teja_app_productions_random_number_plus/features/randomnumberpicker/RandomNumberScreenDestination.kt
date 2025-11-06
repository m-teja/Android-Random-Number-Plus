package com.teja_app_productions_random_number_plus.features.randomnumberpicker

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun RandomNumberScreenDestination(
    randomNumberViewModel: RandomNumberViewModel = hiltViewModel()
) {
    val model by randomNumberViewModel.model.collectAsState()

    RandomNumberScreen(
        model = model,
        onGenerateNewNumber = randomNumberViewModel::generateNewNumber,
        onMinRangeChanged = randomNumberViewModel::onMinRangeChanged,
        onMaxRangeChanged = randomNumberViewModel::onMaxRangeChanged
    )
}
