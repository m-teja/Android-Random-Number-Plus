package com.teja_app_productions_random_number_plus.features.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusPaddings
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
    onDeleteHistoryClicked: () -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "History",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
            )
            IconButton(onClick = onDeleteHistoryClicked) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete History"
                )
            }
        }
        LazyColumn {
            items(model.list.reversed()) { historyItem ->
                Row {
                    Text(text = historyItem.time)
                    Spacer(Modifier.width(RandomNumberPlusPaddings.mediumPadding))
                    Text(text = historyItem.entry)
                }
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
        HistoryList(model = HistoryListModel(sampleHistory)) {}
    }
}