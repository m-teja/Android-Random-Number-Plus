package com.teja_app_productions_random_number_plus.features.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusPaddings
import com.teja_app_productions_random_number_plus.libs.ui.RandomNumberPlusTheme
import kotlinx.coroutines.delay

@Composable
fun FlashingTutorial(
    modifier: Modifier = Modifier,
    message: String,
    initialDelayMillis: Long = 200
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(initialDelayMillis)
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(500)),
        exit = fadeOut(animationSpec = tween(500))
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f)) // Dimming overlay
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null // No ripple effect on tap
                ) { visible = false },
            contentAlignment = Alignment.BottomCenter
        ) {
            val infiniteTransition = rememberInfiniteTransition(label = "tutorial_flash_transition")
            val flashingAlpha by infiniteTransition.animateFloat(
                initialValue = 0.3f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 1000, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "flashing_alpha"
            )

            Surface(
                modifier = Modifier
                    .padding(bottom = 100.dp) // Position above bottom navigation
                    .alpha(flashingAlpha),
                shape = RoundedCornerShape(RandomNumberPlusPaddings.largePadding),
                color = MaterialTheme.colorScheme.secondaryContainer,
                tonalElevation = 8.dp,
                shadowElevation = 8.dp
            ) {
                Text(
                    text = message,
                    modifier = Modifier.padding(
                        horizontal = RandomNumberPlusPaddings.largePadding,
                        vertical = RandomNumberPlusPaddings.mediumPadding
                    ),
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }
}

@Preview
@Composable
private fun FlashingTutorialPreview() {
    RandomNumberPlusTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            FlashingTutorial(message = "This is a tutorial message!")
        }
    }
}
