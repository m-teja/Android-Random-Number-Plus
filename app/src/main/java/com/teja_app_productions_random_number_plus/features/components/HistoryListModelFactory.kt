package com.teja_app_productions_random_number_plus.features.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.teja_app_productions_random_number_plus.libs.date.DateProvider
import javax.inject.Inject

class HistoryListModelFactory @Inject constructor(private val dateProvider: DateProvider) {

    fun createRow(text: AnnotatedString, time: AnnotatedString): HistoryRow {
        return HistoryRow(
            time = time,
            entry = text
        )
    }
}
