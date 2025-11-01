package com.teja_app_productions_random_number_plus.features.coinflip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.teja_app_productions_random_number_plus.features.SharedFeatureViewModel

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
