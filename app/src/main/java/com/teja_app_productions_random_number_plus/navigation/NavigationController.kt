package com.teja_app_productions_random_number_plus.navigation

import android.content.Context
import android.content.Intent
import com.teja_app_productions_random_number_plus.features.FeatureActivity
import com.teja_app_productions_random_number_plus.features.FeatureType

class NavigationController(private val context: Context) {
    fun navigateToFeature(featureType: FeatureType) {
        val intent = Intent(context, FeatureActivity::class.java).apply {
            putExtra("FEATURE_TYPE", featureType)
        }
        context.startActivity(intent)
    }
}
