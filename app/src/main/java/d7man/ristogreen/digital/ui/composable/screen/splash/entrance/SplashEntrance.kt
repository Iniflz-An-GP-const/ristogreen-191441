package d7man.ristogreen.digital.ui.composable.screen.splash.entrance

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import d7man.ristogreen.digital.ui.composable.screen.splash.SplashLockupSlot
import d7man.ristogreen.digital.ui.composable.screen.splash.SplashLogo
import d7man.ristogreen.digital.ui.composable.screen.splash.SplashTitle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

private const val TITLE_DELAY_MS = 300L
private const val HOLD_MS = 1000L
private const val START_SCALE = 0.5f
private val RiseDistance = 12.dp

@Composable
fun SplashEntrance(
    isStarted: Boolean,
    lockup: SplashLockupSlot,
    onFinished: () -> Unit,
) {
    val logoScale = remember { Animatable(START_SCALE) }
    val logoAlpha = remember { Animatable(0f) }
    val titleProgress = remember { Animatable(0f) }

    LaunchedEffect(isStarted) {
        if (!isStarted) return@LaunchedEffect

        launch {
            logoScale.animateTo(
                targetValue = 1f,
                animationSpec = spring(Spring.DampingRatioMediumBouncy, Spring.StiffnessLow),
            )
        }
        launch { logoAlpha.animateTo(1f, tween(durationMillis = 250)) }
        launch {
            delay(TITLE_DELAY_MS.milliseconds)
            titleProgress.animateTo(1f, tween(durationMillis = 400))
        }

        delay((HOLD_MS + TITLE_DELAY_MS + 400).milliseconds)
        onFinished()
    }

    lockup(
        { size ->
            SplashLogo(
                size = size,
                modifier = Modifier.graphicsLayer {
                    scaleX = logoScale.value
                    scaleY = logoScale.value
                    alpha = logoAlpha.value
                },
            )
        },
        {
            SplashTitle(
                modifier = Modifier.graphicsLayer {
                    alpha = titleProgress.value
                    translationY = (1f - titleProgress.value) * RiseDistance.toPx()
                },
            )
        },
    )
}
