package com.teja_app_productions_random_number_plus.libs.preferences

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.lang.reflect.Type
import javax.inject.Inject
import javax.inject.Singleton
import androidx.core.content.edit

@Singleton
class PreferencesManager @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
) {

    fun saveData(key: String, value: String) {
        sharedPreferences.edit { putString(key, value) }
    }

    fun getData(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun <T> saveHistory(key: String, history: List<T>) {
        val json = gson.toJson(history)
        sharedPreferences.edit { putString(key, json) }
    }

    fun <T> getHistory(key: String, type: Type): List<T> {
        val json = sharedPreferences.getString(key, null)
        return if (json != null) {
            try {
                gson.fromJson(json, type) ?: emptyList()
            } catch (e: JsonSyntaxException) {
                // If parsing fails, the stored data is invalid. Clear it.
                sharedPreferences.edit { remove(key) }
                emptyList()
            }
        } else {
            emptyList()
        }
    }
}
