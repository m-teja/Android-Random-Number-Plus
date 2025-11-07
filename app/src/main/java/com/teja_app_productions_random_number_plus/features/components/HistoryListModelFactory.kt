package com.teja_app_productions_random_number_plus.features.components

import androidx.compose.ui.text.AnnotatedString
import com.teja_app_productions_random_number_plus.libs.providers.DateProvider
import javax.inject.Inject

class HistoryListModelFactory @Inject constructor(private val dateProvider: DateProvider) {

    fun createRow(text: AnnotatedString, time: AnnotatedString): HistoryRow {
        return HistoryRow(
            time = time,
            entry = text
        )
    }
}
