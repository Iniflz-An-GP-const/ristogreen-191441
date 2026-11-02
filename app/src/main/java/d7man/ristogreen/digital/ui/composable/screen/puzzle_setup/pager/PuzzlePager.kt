package d7man.ristogreen.digital.ui.composable.screen.puzzle_setup.pager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import d7man.ristogreen.digital.data.model.Puzzle
import d7man.ristogreen.digital.ui.composable.screen.puzzle_setup.pager.PuzzlePage
import d7man.ristogreen.digital.ui.composable.screen.puzzle_setup.pager.rememberPagerFling
import d7man.ristogreen.digital.ui.theme.LocalMotion

private val SideInset = 24.dp
private const val CoveredScale = 0.9f

@Composable
fun PuzzlePager(
    puzzles: List<Puzzle>,
    pagerState: PagerState,
    gridSize: Int,
    modifier: Modifier = Modifier,
) {
    val strength = LocalMotion.current.pageEffectStrength

    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = SideInset),
        flingBehavior = rememberPagerFling(pagerState),
        key = { puzzles[it].id },
    ) { page ->
        PuzzlePage(
            puzzle = puzzles[page],
            gridSize = gridSize,
            modifier = Modifier
                .zIndex(page.toFloat())
                .graphicsLayer {
                    // Positive for pages already passed (to the left of the current one).
                    val offset =
                        pagerState.currentPage - page + pagerState.currentPageOffsetFraction

                    if (offset > 0f) {
                        // Pin the covered page in place instead of letting it scroll away.
                        translationX = offset * size.width

                        val covered = offset.coerceIn(0f, 1f)
                        val scale = (1f - (1f - CoveredScale) * strength * covered).coerceIn(0f, 1f)
                        scaleX = scale
                        scaleY = scale
                        alpha = 1f - covered
                    }
                },
        )
    }
}
