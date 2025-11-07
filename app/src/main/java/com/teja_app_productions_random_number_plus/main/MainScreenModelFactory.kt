package com.teja_app_productions_random_number_plus.main

import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.features.base.FeatureType
import com.teja_app_productions_random_number_plus.main.components.NavToFeatureButtonModel

class MainScreenModelFactory {
    fun create(): MainScreenModel {
        return MainScreenModel(
            listOf(
                NavToFeatureButtonModel(
                    FeatureType.COIN_FLIP,
                    R.drawable.ic_launcher_foreground
                ),
                NavToFeatureButtonModel(
                    FeatureType.RANDOM_NUMBER,
                    R.drawable.ic_launcher_foreground
                ),
                NavToFeatureButtonModel(
                    FeatureType.DICE_ROLL,
                    R.drawable.ic_launcher_foreground
                )
            )
        )
    }
}