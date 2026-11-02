package d7man.ristogreen.digital.ui.composable.shared.modifier.press

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import d7man.ristogreen.digital.ui.composable.shared.modifier.press.rememberPressProgress

private val PressedOffset = 3.dp

@Composable
fun Modifier.pressEffect(interactionSource: InteractionSource): Modifier {
    val progress = rememberPressProgress(interactionSource)

    return graphicsLayer {
        translationY = progress.value * PressedOffset.toPx()
    }
}
