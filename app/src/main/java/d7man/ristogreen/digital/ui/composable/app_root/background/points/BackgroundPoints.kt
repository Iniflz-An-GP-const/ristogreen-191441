package d7man.ristogreen.digital.ui.composable.app_root.background.points

import androidx.compose.ui.geometry.Offset
import kotlin.math.abs
import kotlin.math.hypot
import kotlin.math.min
import kotlin.math.sqrt
import kotlin.random.Random

private const val SEED = 11
private const val ATTEMPTS = 300

fun backgroundPoints(count: Int): List<Offset> {
    val random = Random(SEED)
    val points = mutableListOf<Offset>()
    var minDistance = 0.8f / sqrt(count.toFloat())

    while (points.size < count) {
        var placed = false
        repeat(ATTEMPTS) {
            val candidate = Offset(random.nextFloat(), random.nextFloat())
            if (!placed && points.all { wrappedDistance(it, candidate) >= minDistance }) {
                points += candidate
                placed = true
            }
        }
        if (!placed) minDistance *= 0.9f
    }
    return points
}

private fun wrappedDistance(a: Offset, b: Offset): Float {
    val dx = abs(a.x - b.x)
    val dy = abs(a.y - b.y)
    return hypot(min(dx, 1f - dx), min(dy, 1f - dy))
}
