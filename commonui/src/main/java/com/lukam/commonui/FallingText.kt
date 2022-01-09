package com.lukam.commonui

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

private const val DEFAULT_FALL_DISTANCE = 500
private const val DEFAULT_ALPHA_DURATION = 300
private const val DEFAULT_LETTER_FALL_DELAY = 100

@Composable
fun FallingText(
    modifier: Modifier = Modifier,
    fallingOffset: Int = DEFAULT_FALL_DISTANCE,
    letterFallDelay: Int = DEFAULT_LETTER_FALL_DELAY,
    text: String,
    onAnimationEnd: () -> Unit = { }
) {
    val characters = text.toCharArray()
    Row(modifier) {
        characters.forEachIndexed { index, c ->
            val isVisible = rememberSaveable(index) { mutableStateOf(false) }
            val fadeTransition = updateTransition(isVisible, label = "LetterTransition")

            val alpha by fadeTransition.animateFloat(
                label = "LetterFade",
                transitionSpec = { tween(DEFAULT_ALPHA_DURATION) }
            ) { if(it.value) 1.0f else 0f }
            val offset by fadeTransition.animateDp(
                label = "LetterFall",
                transitionSpec = { spring(Spring.DampingRatioMediumBouncy, Spring.StiffnessLow) }
            ) { if (it.value) 0.dp else (-fallingOffset).dp }
            Text(
                text = c.toString(),
                modifier = Modifier
                    .offset(y = offset)
                    .alpha(alpha),
                style = LogoTextStyle
            )

            LaunchedEffect(index) {
                delay(letterFallDelay.toLong() * index)
                isVisible.value = true

                if (index == characters.lastIndex) {
                    delay(DEFAULT_ALPHA_DURATION + 500L)
                    onAnimationEnd()
                }
            }
        }
    }
}

@Preview(name = "falling text")
@Composable
private fun FallingTextPreview() {
    FallingText(text = "Hello")
}
