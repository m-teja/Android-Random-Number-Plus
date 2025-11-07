package com.teja_app_productions_random_number_plus.features.coinflip

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.features.components.FeatureScaffold
import com.teja_app_productions_random_number_plus.features.components.FeatureScaffoldModel
import com.teja_app_productions_random_number_plus.features.components.HistoryListModel
import com.teja_app_productions_random_number_plus.features.components.HistoryRow
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme

@Composable
fun CoinFlipScreen(
    modifier: Modifier = Modifier,
    model: CoinFlipScreenModel,
    onFlipCoin: () -> Unit,
    onDeleteHistoryClicked: () -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        FeatureScaffold(
            model = FeatureScaffoldModel(
                showTutorial = model.showTutorial,
                tutorialMessage = stringResource(R.string.coin_flip_tutorial_message),
                history = model.history,
            ),
            onDeleteHistoryClicked = onDeleteHistoryClicked
        ) {
            Text(text = model.result.name.lowercase().replaceFirstChar { it.titlecase() })
            Button(onClick = onFlipCoin) {
                Text(text = "Flip Coin")
            }
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
            onFlipCoin = {},
            onDeleteHistoryClicked = {},
        )
    }
}
