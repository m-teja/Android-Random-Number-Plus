package com.teja_app_productions_random_number_plus.features.randomnumberpicker

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
            )
        ) {
            Text(
                text = model.result.toString(),
                fontSize = RandomNumberPlusPaddings.ResultTextSize
            )
            Row(horizontalArrangement = Arrangement.spacedBy(RandomNumberPlusPaddings.largePadding)) {
                NumberPicker(
                    value = model.minRange,
                    onValueChange = onMinRangeChanged,
                    label = { Text(text = stringResource(R.string.random_number_picker_min_label)) }
                )
                NumberPicker(
                    value = model.maxRange,
                    onValueChange = onMaxRangeChanged,
                    label = { Text(text = stringResource(R.string.random_number_picker_max_label)) }
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
            onMaxRangeChanged = {}
        )
    }
}
