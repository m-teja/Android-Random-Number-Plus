package com.teja_app_productions_random_number_plus.main.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme

data class NavToFeatureButtonModel(
    @DrawableRes val imageRes: Int
)

@Composable
fun NavToFeatureButton(
    modifier: Modifier = Modifier,
    model: NavToFeatureButtonModel,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(100.dp)
    ) {
        Image(
            painter = painterResource(id = model.imageRes),
            contentDescription = "Feature Button"
        )
    }
}

@Preview
@Composable
fun NavToFeatureButtonPreview() {
    RandomNumberPlusTheme {
        NavToFeatureButton(
            model = NavToFeatureButtonModel(R.drawable.ic_launcher_foreground),
            onClick = {}
        )
    }
}