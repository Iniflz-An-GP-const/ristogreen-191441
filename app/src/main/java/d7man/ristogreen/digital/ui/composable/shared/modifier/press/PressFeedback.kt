package d7man.ristogreen.digital.ui.composable.shared.modifier.press

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import d7man.ristogreen.digital.ui.composable.shared.modifier.press.pressEffect

@Composable
fun Modifier.pressFeedback(interactionSource: InteractionSource): Modifier =
    pressEffect(interactionSource)
