package com.teja_app_productions_random_number_plus.libs.date

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class DateProvider @Inject constructor() {

    fun getFormattedTimestamp(): String {
        val formatter = DateTimeFormatter.ofPattern("MMM dd, HH:mm:ss")
        return LocalDateTime.now().format(formatter)
    }
}
