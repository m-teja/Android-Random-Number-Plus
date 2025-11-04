package com.teja_app_productions_random_number_plus.features.coinflip

import javax.inject.Inject
import kotlin.random.Random

class CoinFlipScreenModelFactory @Inject constructor() {

    fun create(): CoinFlipScreenModel {
        val initialResult = generateRandomOutcome()
        return CoinFlipScreenModel(
            result = initialResult,
            history = listOf(CoinFlipResult(initialResult)),
            showTutorial = true // Show tutorial on first creation
        )
    }

    fun flip(currentState: CoinFlipScreenModel): CoinFlipScreenModel {
        val newResult = generateRandomOutcome()
        val newHistoryEntry = CoinFlipResult(newResult)
        return currentState.copy(
            result = newResult,
            history = currentState.history + newHistoryEntry,
            showTutorial = false // Hide tutorial after first flip
        )
    }

    private fun generateRandomOutcome(): CoinFlipOutcome {
        return if (Random.nextBoolean()) CoinFlipOutcome.HEADS else CoinFlipOutcome.TAILS
    }
}
