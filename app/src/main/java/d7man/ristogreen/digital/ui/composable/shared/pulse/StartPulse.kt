package d7man.ristogreen.digital.ui.composable.shared.pulse

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import d7man.ristogreen.digital.ui.composable.shared.pulse.timing.StartPulseTiming
import d7man.ristogreen.digital.ui.composable.shared.pulse.pulseEffect

@Composable
fun Modifier.startPulse(cornerRadius: Dp): Modifier = pulseEffect(cornerRadius, StartPulseTiming)
