package com.teja_app_productions_random_number_plus.features.coinflip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme

@Composable
fun CoinFlipScreen(
    model: CoinFlipScreenModel,
    onFlipCoin: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = model.result)
        Button(onClick = onFlipCoin) {
            Text(text = "Flip Coin")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CoinFlipScreenPreview() {
    RandomNumberPlusTheme {
        CoinFlipScreen(
            model = CoinFlipScreenModel(result = "Heads"),
            onFlipCoin = {}
        )
    }
}
