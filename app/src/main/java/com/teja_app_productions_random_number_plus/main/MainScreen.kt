package com.teja_app_productions_random_number_plus.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.features.FeatureType
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusPaddings
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme
import com.teja_app_productions_random_number_plus.main.components.NavToFeatureButton
import com.teja_app_productions_random_number_plus.main.components.NavToFeatureButtonModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onNavigateToFeature: (FeatureType) -> Unit,
    model: MainScreenModel,
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = RandomNumberPlusPaddings.verticalScreenPadding,
                    horizontal = RandomNumberPlusPaddings.horizontalScreenPadding
                )
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(RandomNumberPlusPaddings.largePadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainButtonRow(
                onNavigateToFeature = onNavigateToFeature,
                model = model
            )
        }
    }
}

@Composable
private fun MainButtonRow(
    modifier: Modifier = Modifier,
    onNavigateToFeature: (FeatureType) -> Unit,
    model: MainScreenModel,
) {
    model.featureButtonList.chunked(2).forEach { rowOfButtons ->
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(RandomNumberPlusPaddings.largePadding)
        ) {
            rowOfButtons.forEach { featureButtonModel ->
                NavToFeatureButton(
                    modifier = Modifier
                        .weight(1f),
                    model = featureButtonModel,
                    onClick = onNavigateToFeature
                )
            }
            if (rowOfButtons.size < 2) {
                Spacer(modifier = Modifier.weight(1f))
            }
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
                listOf(
                    NavToFeatureButtonModel(
                        FeatureType.COIN_FLIP,
                        R.drawable.ic_launcher_foreground
                    ),
                    NavToFeatureButtonModel(
                        FeatureType.RANDOM_NUMBER,
                        R.drawable.ic_launcher_foreground
                    ),
                )
            )
        )
    }
}
