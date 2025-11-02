package com.teja_app_productions_random_number_plus.libs.preferences

import android.content.SharedPreferences
import com.google.gson.Gson
import com.teja_app_productions_random_number_plus.features.FeatureHistory
import java.lang.reflect.Type
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
) {

    fun saveData(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getData(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun saveHistory(key: String, history: List<FeatureHistory>) {
        val json = gson.toJson(history)
        sharedPreferences.edit().putString(key, json).apply()
    }

    fun getHistory(key: String, type: Type): List<FeatureHistory> {
        val json = sharedPreferences.getString(key, null)
        return if (json != null) {
            gson.fromJson(json, type) ?: emptyList()
        } else {
            emptyList()
        }
    }
}
