package com.teja_app_productions_random_number_plus.features

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.teja_app_productions_random_number_plus.features.coinflip.CoinFlipScreenDestination
import com.teja_app_productions_random_number_plus.features.randomnumberpicker.RandomNumberScreenDestination
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusPaddings
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeatureActivity : ComponentActivity() {

    companion object {
        private const val EXTRA_FEATURE_TYPE = "FEATURE_TYPE"

        fun newIntent(context: Context, featureType: FeatureType): Intent {
            return Intent(context, FeatureActivity::class.java).apply {
                putExtra(EXTRA_FEATURE_TYPE, featureType)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val featureType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(EXTRA_FEATURE_TYPE, FeatureType::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra(EXTRA_FEATURE_TYPE) as? FeatureType
        }

        setContent {
            RandomNumberPlusTheme {
                Surface {
                    when (featureType) {
                        FeatureType.COIN_FLIP -> CoinFlipScreenDestination()
                        FeatureType.RANDOM_NUMBER -> RandomNumberScreenDestination()
                        else -> { /* Handle error or other feature cases */ }
                    }
                }
            }
        }
    }
}
