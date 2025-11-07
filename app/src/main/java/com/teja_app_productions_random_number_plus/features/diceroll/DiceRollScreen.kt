package com.teja_app_productions_random_number_plus.features.diceroll

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.features.components.FeatureScaffold
import com.teja_app_productions_random_number_plus.features.components.FeatureScaffoldModel
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusPaddings
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme

@Composable
fun DiceRollScreen(
    modifier: Modifier = Modifier,
    model: DiceRollScreenModel,
    onGenerateNewNumbers: () -> Unit,
    onDeleteHistoryClicked: () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .clickable(onClick = onGenerateNewNumbers)
    ) {
        FeatureScaffold(
            model = FeatureScaffoldModel(
                showTutorial = model.showTutorial,
                tutorialMessage = stringResource(id = R.string.dice_roll_tutorial_message),
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
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = model.firstDie.toString(),
                        fontSize = RandomNumberPlusPaddings.ResultTextSize,
                        modifier = Modifier.padding(horizontal = RandomNumberPlusPaddings.smallPadding)
                    )
                    Text(
                        text = model.secondDie.toString(),
                        fontSize = RandomNumberPlusPaddings.ResultTextSize,
                        modifier = Modifier.padding(horizontal = RandomNumberPlusPaddings.smallPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DiceRollScreenPreview() {
    RandomNumberPlusTheme {
        DiceRollScreen(
            model = DiceRollScreenModel(
                firstDie = 1,
                secondDie = 6
            ),
            onGenerateNewNumbers = {},
            onDeleteHistoryClicked = {}
        )
    }
}
