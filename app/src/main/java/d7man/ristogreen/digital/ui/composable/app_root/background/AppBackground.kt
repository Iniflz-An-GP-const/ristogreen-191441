package d7man.ristogreen.digital.ui.composable.app_root.background

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import d7man.ristogreen.digital.ui.composable.app_root.background.decor.BackgroundDecor
import d7man.ristogreen.digital.ui.composable.app_root.background.motion.rememberBackgroundMotion
import d7man.ristogreen.digital.ui.composable.app_root.background.points.backgroundPoints

@Composable
fun AppBackground(modifier: Modifier = Modifier) {
    BackgroundDecor(
        motion = rememberBackgroundMotion(),
        points = ::backgroundPoints,
        modifier = modifier
    )
}
