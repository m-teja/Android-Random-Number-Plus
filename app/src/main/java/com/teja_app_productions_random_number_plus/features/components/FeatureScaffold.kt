package com.teja_app_productions_random_number_plus.features.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusPaddings
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme

data class FeatureScaffoldModel(
    val showTutorial: Boolean,
    val tutorialMessage: String,
    val history: HistoryListModel
)

@Composable
fun FeatureScaffold(
    model: FeatureScaffoldModel,
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Center,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier
            .padding(
                horizontal = RandomNumberPlusPaddings.horizontalScreenPadding,
                vertical = RandomNumberPlusPaddings.verticalScreenPadding
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment
        ) {
            content()
            HistoryList(
                model = model.history,
                modifier = Modifier.padding(top = RandomNumberPlusPaddings.largePadding)
            )
        }
    }

    if (model.showTutorial) {
        FlashingTutorial(message = model.tutorialMessage)
    }
}

@Preview(showBackground = true)
@Composable
private fun FeatureScaffoldPreview() {
    RandomNumberPlusTheme {
        FeatureScaffold(
            model = FeatureScaffoldModel(
                showTutorial = true,
                tutorialMessage = "This is a tutorial message.",
                history = HistoryListModel(
                    list = listOf(
                        HistoryRow(
                            time = buildAnnotatedString { append("Jan 01, 10:43:15") },
                            entry = buildAnnotatedString { append("Preview entry 1") }
                        ),
                        HistoryRow(
                            time = buildAnnotatedString { append("Jan 01, 10:43:16") },
                            entry = buildAnnotatedString { append("Preview entry 2") }
                        )
                    )
                )
            )
        ) {
            Text(text = "Preview Content")
        }
    }
}
