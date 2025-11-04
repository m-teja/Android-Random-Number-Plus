package com.teja_app_productions_random_number_plus.features.coinflip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.teja_app_productions_random_number_plus.features.components.FlashingTutorial
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme
import com.teja_app_productions_random_number_plus.R

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
                showTutorial = true
            ),
            onFlipCoin = {}
        )
    }
}
