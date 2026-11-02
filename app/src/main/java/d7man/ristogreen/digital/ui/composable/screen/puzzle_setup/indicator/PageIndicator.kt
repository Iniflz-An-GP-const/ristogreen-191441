package d7man.ristogreen.digital.ui.composable.screen.puzzle_setup.indicator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp
import d7man.ristogreen.digital.ui.composable.screen.puzzle_setup.indicator.PageIndicatorDefaults
import d7man.ristogreen.digital.ui.composable.screen.puzzle_setup.indicator.PageIndicatorPlaceholder
import d7man.ristogreen.digital.ui.composable.screen.puzzle_setup.indicator.pagePositionSemantics
import kotlin.math.max

private val TrackWidth = 160.dp
private val TrackHeight = 4.dp
private val MinThumbWidth = 16.dp

@Composable
fun PageIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
    if (PageIndicatorDefaults.hasNothingToShow(pagerState)) {
        PageIndicatorPlaceholder(modifier)
        return
    }

    val count = pagerState.pageCount
    val trackColor = MaterialTheme.colorScheme.outlineVariant
    val thumbColor = MaterialTheme.colorScheme.primary

    Canvas(
        modifier = modifier
            .pagePositionSemantics(pagerState)
            .width(TrackWidth)
            .height(PageIndicatorDefaults.Height),
    ) {
        val trackHeight = TrackHeight.toPx()
        val top = (size.height - trackHeight) / 2f
        val corner = CornerRadius(trackHeight / 2f)

        drawRoundRect(
            color = trackColor,
            topLeft = Offset(0f, top),
            size = Size(size.width, trackHeight),
            cornerRadius = corner,
        )

        val position = (pagerState.currentPage + pagerState.currentPageOffsetFraction)
            .coerceIn(0f, count - 1f)
        val thumbWidth = max(size.width / count, MinThumbWidth.toPx())
        val thumbLeft = (size.width - thumbWidth) * position / (count - 1)

        drawRoundRect(
            color = thumbColor,
            topLeft = Offset(thumbLeft, top),
            size = Size(thumbWidth, trackHeight),
            cornerRadius = corner,
        )
    }
}
