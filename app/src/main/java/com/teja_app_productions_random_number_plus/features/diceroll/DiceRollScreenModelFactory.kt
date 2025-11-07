package com.teja_app_productions_random_number_plus.features.diceroll

import androidx.compose.ui.text.buildAnnotatedString
import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.features.base.BaseScreenModelFactory
import com.teja_app_productions_random_number_plus.features.components.HistoryListModel
import com.teja_app_productions_random_number_plus.features.components.HistoryListModelFactory
import com.teja_app_productions_random_number_plus.features.components.HistoryRow
import com.teja_app_productions_random_number_plus.libs.providers.DateProvider
import com.teja_app_productions_random_number_plus.libs.providers.StringProvider
import javax.inject.Inject
import kotlin.random.Random

class DiceRollScreenModelFactory @Inject constructor(
    private val stringProvider: StringProvider,
    private val historyListModelFactory: HistoryListModelFactory,
    private val dateProvider: DateProvider,
) : BaseScreenModelFactory<DiceRollResult> {

    fun create(): DiceRollScreenModel {
        val initialResult = generateDiceRoll()
        val historyRow = createHistoryRow(
            initialResult,
            dateProvider.getFormattedTimestamp()
        )
        return DiceRollScreenModel(
            firstDie = initialResult.firstDie,
            secondDie = initialResult.secondDie,
            history = HistoryListModel(listOf(historyRow)),
            showTutorial = true
        )
    }

    fun generateNewNumbers(currentState: DiceRollScreenModel): DiceRollScreenModel {
        val newResult = generateDiceRoll()
        val newHistory = currentState.history.list + createHistoryRow(
            newResult,
            dateProvider.getFormattedTimestamp()
        )
        return currentState.copy(
            firstDie = newResult.firstDie,
            secondDie = newResult.secondDie,
            history = HistoryListModel(newHistory),
        )
    }

    private fun generateDiceRoll(): DiceRollResult {
        return DiceRollResult(Random.nextInt(1, 7), Random.nextInt(1, 7))
    }

    override fun createHistoryRow(entry: DiceRollResult, timeStamp: String): HistoryRow {
        val text = buildAnnotatedString {
            append(stringProvider.getString(R.string.dice_roll_history_item_text, entry.firstDie, entry.secondDie))
        }
        val time = buildAnnotatedString {
            append(timeStamp)
        }

        return historyListModelFactory.createRow(text, time)
    }
}
