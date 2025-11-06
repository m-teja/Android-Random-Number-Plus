package com.teja_app_productions_random_number_plus.features.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun NumberPicker(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null
) {
    var text by remember(value) { mutableStateOf(value.toString()) }

    TextField(
        value = text,
        onValueChange = { newText ->
            if (newText.length <= 9) {
                val filteredText = newText.filter { it.isDigit() }
                if (text != filteredText) {
                    text = filteredText
                    filteredText.toIntOrNull()?.let(onValueChange)
                }
            }
        },
        label = label,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}
