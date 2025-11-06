package com.teja_app_productions_random_number_plus.features.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme

data class HistoryRow(
    val entry: AnnotatedString,
    val time: AnnotatedString,
)

data class HistoryListModel(
    val list: List<HistoryRow>
)

@Composable
fun HistoryList(
    modifier: Modifier = Modifier,
    model: HistoryListModel,
) {
    LazyColumn(modifier = modifier) {
        items(model.list.reversed()) { historyItem ->
            Row {
                Text(text = historyItem.time)
                Spacer(Modifier.width(8.dp))
                Text(text = historyItem.entry)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HistoryListPreview() {
    val sampleHistory = listOf(
        HistoryRow(
            time = buildAnnotatedString { append("Jan 01, 10:43:15") },
            entry = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Green)) {
                    append("Heads")
                }
            }
        ),
        HistoryRow(
            time = buildAnnotatedString { append("Jan 01, 10:43:16") },
            entry = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                    append("Tails")
                }
            }
        )
    )
    RandomNumberPlusTheme {
        HistoryList(model = HistoryListModel(sampleHistory))
    }
}
