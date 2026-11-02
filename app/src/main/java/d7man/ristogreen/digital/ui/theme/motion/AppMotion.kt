package d7man.ristogreen.digital.ui.theme.motion

import androidx.compose.animation.core.Spring
import d7man.ristogreen.digital.ui.theme.motion.Motion

val AppMotion = Motion(
    pageEffectStrength = 1f,
    settleDampingRatio = Spring.DampingRatioNoBouncy,
    settleStiffness = Spring.StiffnessMediumLow,
    crossfadeMillis = 300,
)
