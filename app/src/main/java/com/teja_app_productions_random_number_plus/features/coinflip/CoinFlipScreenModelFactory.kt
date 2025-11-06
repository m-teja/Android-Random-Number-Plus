package com.teja_app_productions_random_number_plus.features.coinflip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.teja_app_productions_random_number_plus.features.BaseScreenModelFactory
import com.teja_app_productions_random_number_plus.features.components.HistoryListModel
import com.teja_app_productions_random_number_plus.features.components.HistoryListModelFactory
import com.teja_app_productions_random_number_plus.features.components.HistoryRow
import com.teja_app_productions_random_number_plus.libs.date.DateProvider
import javax.inject.Inject
import kotlin.random.Random

class CoinFlipScreenModelFactory @Inject constructor(
    private val historyListModelFactory: HistoryListModelFactory,
    private val dateProvider: DateProvider,
) : BaseScreenModelFactory<CoinFlipResult> {

    fun create(): CoinFlipScreenModel {
        val initialResult = generateRandomOutcome()
        val historyRow = createHistoryRow(
            CoinFlipResult(initialResult),
            dateProvider.getFormattedTimestamp()
        )
        return CoinFlipScreenModel(
            result = initialResult,
            history = HistoryListModel(listOf(historyRow)),
            showTutorial = true
        )
    }

    fun flip(currentState: CoinFlipScreenModel): CoinFlipScreenModel {
        val newResult = generateRandomOutcome()
        val newHistory = currentState.history.list + createHistoryRow(
            CoinFlipResult(newResult),
            dateProvider.getFormattedTimestamp()
        )
        return currentState.copy(
            result = newResult,
            history = HistoryListModel(newHistory),
        )
    }

    private fun generateRandomOutcome(): CoinFlipOutcome {
        return if (Random.nextBoolean()) CoinFlipOutcome.HEADS else CoinFlipOutcome.TAILS
    }

    override fun createHistoryRow(entry: CoinFlipResult, timeStamp: String): HistoryRow {
        val (color, flipString) = if (entry.outcome == CoinFlipOutcome.HEADS) {
            Color.Green to "Heads"
        } else {
            Color.Red to "Tails"
        }
        val text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = color)) {
                append(flipString)
            }
        }
        val time = buildAnnotatedString {
            append(timeStamp)
        }

        return historyListModelFactory.createRow(text, time)
    }
}
