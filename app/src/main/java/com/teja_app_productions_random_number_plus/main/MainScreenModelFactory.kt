package com.teja_app_productions_random_number_plus.main

import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.main.components.NavToFeatureButtonModel

class MainScreenModelFactory {
    fun create(): MainScreenModel {
        return MainScreenModel(
            listOf(
                NavToFeatureButtonModel(
                    R.drawable.ic_launcher_foreground
                ),
                NavToFeatureButtonModel(
                    R.drawable.ic_launcher_foreground
                ),
                NavToFeatureButtonModel(
                    R.drawable.ic_launcher_foreground
                ),
                NavToFeatureButtonModel(
                    R.drawable.ic_launcher_foreground
                ),
                NavToFeatureButtonModel(
                    R.drawable.ic_launcher_foreground
                ),
                NavToFeatureButtonModel(
                    R.drawable.ic_launcher_foreground
                ),
                NavToFeatureButtonModel(
                    R.drawable.ic_launcher_foreground
                )
            )
        )
    }
}