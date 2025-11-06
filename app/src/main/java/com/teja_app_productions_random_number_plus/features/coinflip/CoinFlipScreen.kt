package com.teja_app_productions_random_number_plus.features.coinflip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.features.components.FlashingTutorial
import com.teja_app_productions_random_number_plus.features.components.HistoryList
import com.teja_app_productions_random_number_plus.features.components.HistoryListModel
import com.teja_app_productions_random_number_plus.features.components.HistoryRow
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme

@Composable
fun CoinFlipScreen(
    model: CoinFlipScreenModel,
    onFlipCoin: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = model.result.name.lowercase().replaceFirstChar { it.titlecase() })
            Button(onClick = onFlipCoin) {
                Text(text = "Flip Coin")
            }
            HistoryList(
                model = model.history,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        if (model.showTutorial) {
            FlashingTutorial(message = stringResource(R.string.coin_flip_tutorial_message))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CoinFlipScreenPreview() {
    RandomNumberPlusTheme {
        CoinFlipScreen(
            model = CoinFlipScreenModel(
                result = CoinFlipOutcome.HEADS,
                history = HistoryListModel(
                    list = listOf(
                        HistoryRow(
                            time = buildAnnotatedString { append("Jan 01, 10:43:15") },
                            entry = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Green)) {
                                    append("Heads")
                                }
                            }
                        ),
                        HistoryRow(
                            time = buildAnnotatedString { append("Jan 01, 10:43:16") },
                            entry = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                                    append("Tails")
                                }
                            }
                        )
                    )
                ),
                showTutorial = true
            ),
            onFlipCoin = {}
        )
    }
}
