package com.teja_app_productions_random_number_plus.features.randomnumberpicker

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.features.components.FeatureScaffold
import com.teja_app_productions_random_number_plus.features.components.FeatureScaffoldModel
import com.teja_app_productions_random_number_plus.features.components.NumberPicker
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusPaddings
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme

@Composable
fun RandomNumberScreen(
    modifier: Modifier = Modifier,
    model: RandomNumberScreenModel,
    onGenerateNewNumber: () -> Unit,
    onMinRangeChanged: (Int) -> Unit,
    onMaxRangeChanged: (Int) -> Unit,
    onDeleteHistoryClicked: () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .clickable(onClick = onGenerateNewNumber)
    ) {
        FeatureScaffold(
            model = FeatureScaffoldModel(
                showTutorial = model.showTutorial,
                tutorialMessage = stringResource(id = R.string.random_number_picker_tutorial_message),
                history = model.history
            ),
            onDeleteHistoryClicked = onDeleteHistoryClicked
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(RandomNumberPlusPaddings.mediumPadding),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NumberPicker(
                        modifier = Modifier.weight(1f),
                        value = model.minRange,
                        onValueChange = onMinRangeChanged,
                        label = { Text(text = stringResource(R.string.random_number_picker_min_label)) }
                    )

                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = model.result.toString(),
                            modifier = Modifier
                                .padding(horizontal = RandomNumberPlusPaddings.smallPadding),
                            softWrap = false,
                            autoSize = TextAutoSize.StepBased(minFontSize = 10.sp, maxFontSize = RandomNumberPlusPaddings.ResultTextSize, stepSize = 1.sp)
                        )
                    }

                    NumberPicker(
                        modifier = Modifier.weight(1f),
                        value = model.maxRange,
                        onValueChange = onMaxRangeChanged,
                        label = { Text(text = stringResource(R.string.random_number_picker_max_label)) }
                    )
                }

                Text(
                    text = stringResource(id = R.string.random_number_picker_error_message_min_greater_than_max),
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(top = RandomNumberPlusPaddings.smallPadding)
                        .alpha(if (!model.isInputValid) 1f else 0f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RandomNumberScreenPreview() {
    RandomNumberPlusTheme {
        RandomNumberScreen(
            model = RandomNumberScreenModel(
                result = 100,
            ),
            onGenerateNewNumber = {},
            onMinRangeChanged = {},
            onMaxRangeChanged = {},
            onDeleteHistoryClicked = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RandomNumberScreenErrorPreview() {
    RandomNumberPlusTheme {
        RandomNumberScreen(
            model = RandomNumberScreenModel(
                result = 100,
                isInputValid = false
            ),
            onGenerateNewNumber = {},
            onMinRangeChanged = {},
            onMaxRangeChanged = {},
            onDeleteHistoryClicked = {},
        )
    }
}
