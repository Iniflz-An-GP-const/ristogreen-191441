package d7man.ristogreen.digital.ui.composable.app_root.background.decor

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalDensity
import d7man.ristogreen.digital.ui.composable.app_root.background.BackgroundMotion
import d7man.ristogreen.digital.ui.composable.app_root.background.BackgroundPoints
import d7man.ristogreen.digital.ui.composable.app_root.background.drawTiled
import kotlin.random.Random

private const val TILE_DP = 150f
private const val CONFETTI_ALPHA = 0.22f
private const val COUNT = 9

private data class Fleck(
    val x: Float,
    val y: Float,
    val sizeDp: Float,
    val rotation: Float,
    val colorIndex: Int,
)

@Composable
fun BackgroundDecor(
    motion: BackgroundMotion,
    points: BackgroundPoints,
    modifier: Modifier = Modifier
) {
    val scheme = MaterialTheme.colorScheme
    val colors = listOf(scheme.primary, scheme.secondary, scheme.tertiary)
    val density = LocalDensity.current.density
    val flecks = remember(points) {
        val random = Random(SEED)
        points(COUNT).mapIndexed { index, point ->
            Fleck(
                x = point.x,
                y = point.y,
                sizeDp = 8f + random.nextFloat() * 8f,
                rotation = random.nextFloat() * 90f,
                colorIndex = index % colors.size,
            )
        }
    }

    Canvas(modifier = modifier.fillMaxSize()) {
        val alpha = motion.alpha()
        val tile = TILE_DP * density

        drawTiled(tile, motion.shift()) {
            flecks.forEach { fleck ->
                val side = fleck.sizeDp * density
                rotate(
                    degrees = fleck.rotation,
                    pivot = Offset(fleck.x * tile + side / 2f, fleck.y * tile + side / 2f)
                ) {
                    drawRoundRect(
                        color = colors[fleck.colorIndex].copy(alpha = CONFETTI_ALPHA * alpha),
                        topLeft = Offset(fleck.x * tile, fleck.y * tile),
                        size = Size(side, side),
                        cornerRadius = CornerRadius(side * 0.22f),
                    )
                }
            }
        }
    }
}

private const val SEED = 20
