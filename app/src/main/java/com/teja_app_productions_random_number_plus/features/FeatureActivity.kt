package com.teja_app_productions_random_number_plus.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.teja_app_productions_random_number_plus.features.coinflip.CoinFlipScreenDestination
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeatureActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val featureType = intent.getSerializableExtra("FEATURE_TYPE") as? FeatureType

        setContent {
            RandomNumberPlusTheme {
                when (featureType) {
                    FeatureType.COIN_FLIP -> CoinFlipScreenDestination()
                    else -> { /* Handle error or other feature cases */ }
                }
            }
        }
    }
}
