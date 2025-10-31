package com.teja_app_productions_random_number_plus.navigation

import android.content.Context
import android.content.Intent
import com.teja_app_productions_random_number_plus.features.FeatureActivity

class NavigationController(private val context: Context) {
    fun navigateToFeature() {
        val intent = Intent(context, FeatureActivity::class.java)
        context.startActivity(intent)
    }
}