package com.teja_app_productions_random_number_plus.features.randomnumberpicker

import androidx.compose.ui.text.buildAnnotatedString
import com.teja_app_productions_random_number_plus.features.base.BaseScreenModelFactory
import com.teja_app_productions_random_number_plus.features.components.HistoryListModel
import com.teja_app_productions_random_number_plus.features.components.HistoryListModelFactory
import com.teja_app_productions_random_number_plus.features.components.HistoryRow
import com.teja_app_productions_random_number_plus.libs.date.DateProvider
import javax.inject.Inject
import kotlin.random.Random

class RandomNumberScreenModelFactory @Inject constructor(
    private val historyListModelFactory: HistoryListModelFactory,
    private val dateProvider: DateProvider,
) : BaseScreenModelFactory<RandomNumberResult> {

    fun create(): RandomNumberScreenModel {
        val minRange = RANDOM_NUMBER_PICKER_MIN_RANGE
        val maxRange = RANDOM_NUMBER_PICKER_MAX_RANGE
        val initialResult = generateRandomNumber(minRange, maxRange)
        val historyRow = createHistoryRow(
            RandomNumberResult(initialResult, minRange, maxRange),
            dateProvider.getFormattedTimestamp()
        )
        return RandomNumberScreenModel(
            result = initialResult,
            minRange = minRange,
            maxRange = maxRange,
            history = HistoryListModel(listOf(historyRow)),
            showTutorial = true
        )
    }

    fun generateNewNumber(currentState: RandomNumberScreenModel): RandomNumberScreenModel {
        val newResult = generateRandomNumber(currentState.minRange, currentState.maxRange)
        val newHistory = currentState.history.list + createHistoryRow(
            RandomNumberResult(newResult, currentState.minRange, currentState.maxRange),
            dateProvider.getFormattedTimestamp()
        )
        return currentState.copy(
            result = newResult,
            history = HistoryListModel(newHistory),
            isInputValid = true,
        )
    }

    fun updateMinRange(currentState: RandomNumberScreenModel, newMin: Int): RandomNumberScreenModel {
        return currentState.copy(
            minRange = newMin,
            isInputValid = newMin <= currentState.maxRange
        )
    }

    fun updateMaxRange(currentState: RandomNumberScreenModel, newMax: Int): RandomNumberScreenModel {
        return currentState.copy(
            maxRange = newMax,
            isInputValid = newMax >= currentState.minRange
        )
    }

    private fun generateRandomNumber(min: Int, max: Int): Int {
        return Random.nextInt(min, max + 1)
    }

    override fun createHistoryRow(entry: RandomNumberResult, timeStamp: String): HistoryRow {
        val text = buildAnnotatedString {
            append("Result: ${entry.value} (Range: ${entry.minRange}-${entry.maxRange})")
        }
        val time = buildAnnotatedString {
            append(timeStamp)
        }

        return historyListModelFactory.createRow(text, time)
    }
}
