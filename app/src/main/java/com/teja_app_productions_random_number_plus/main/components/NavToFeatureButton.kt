package com.teja_app_productions_random_number_plus.main.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teja_app_productions_random_number_plus.R
import com.teja_app_productions_random_number_plus.features.base.FeatureType
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme

data class NavToFeatureButtonModel(
    val featureType: FeatureType,
    @DrawableRes val imageRes: Int
)

@Composable
fun NavToFeatureButton(
    modifier: Modifier = Modifier,
    model: NavToFeatureButtonModel,
    onClick: (FeatureType) -> Unit,
) {
    Button(
        onClick = {
            onClick(model.featureType)
        },
        modifier = modifier
            .aspectRatio(1f),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
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
            model = NavToFeatureButtonModel(
                FeatureType.COIN_FLIP,
                R.drawable.ic_launcher_foreground
            ),
            onClick = {}
        )
    }
}