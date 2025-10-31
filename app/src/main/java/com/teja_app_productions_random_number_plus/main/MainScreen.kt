package com.teja_app_productions_random_number_plus.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme
import com.teja_app_productions_random_number_plus.main.components.NavToFeatureButton
import com.teja_app_productions_random_number_plus.main.components.NavToFeatureButtonModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onNavigateToFeature: () -> Unit,
    model: MainScreenModel,
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello from Main Screen!"
            )
            NavToFeatureButton(
                model = NavToFeatureButtonModel(R.drawable.ic_launcher_background),
                onClick = onNavigateToFeature
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    RandomNumberPlusTheme {
        MainScreen(
            onNavigateToFeature = {},
            model = MainScreenModel(
                listOf()
            )
        )
    }
}