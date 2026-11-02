package d7man.ristogreen.digital.ui.composable.screen.puzzle_setup.pager

import androidx.compose.foundation.gestures.TargetedFlingBehavior
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import d7man.ristogreen.digital.ui.theme.LocalMotion

@Composable
fun rememberPagerFling(pagerState: PagerState): TargetedFlingBehavior {
    val motion = LocalMotion.current

    return PagerDefaults.flingBehavior(
        state = pagerState,
        snapAnimationSpec = motion.settleSpec,
    )
}
