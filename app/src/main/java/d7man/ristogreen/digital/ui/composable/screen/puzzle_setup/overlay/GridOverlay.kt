package d7man.ristogreen.digital.ui.composable.screen.puzzle_setup.overlay

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import d7man.ristogreen.digital.ui.theme.LocalMotion

private val GapWidth = 4.dp

@Composable
fun GridOverlay(
    gridSize: Int,
    modifier: Modifier = Modifier,
) {
    val gapColor = MaterialTheme.colorScheme.background

    val motion = LocalMotion.current

    Crossfade(
        targetState = gridSize,
        modifier = modifier,
        animationSpec = tween(durationMillis = motion.crossfadeMillis),
        label = "gridOverlayGaps",
    ) { cells ->
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = GapWidth.toPx()

            for (index in 1 until cells) {
                val x = size.width * index / cells
                val y = size.height * index / cells
                drawLine(gapColor, Offset(x, 0f), Offset(x, size.height), strokeWidth)
                drawLine(gapColor, Offset(0f, y), Offset(size.width, y), strokeWidth)
            }
        }
    }
}
