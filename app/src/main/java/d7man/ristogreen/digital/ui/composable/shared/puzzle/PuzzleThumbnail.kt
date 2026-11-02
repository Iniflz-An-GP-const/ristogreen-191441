package d7man.ristogreen.digital.ui.composable.shared.puzzle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import d7man.ristogreen.digital.data.model.Puzzle
import d7man.ristogreen.digital.di.DispatchersQualifiers
import d7man.ristogreen.digital.utils.THUMBNAIL_MAX_DIMENSION
import d7man.ristogreen.digital.utils.loadPuzzleBitmap
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.compose.koinInject
import androidx.compose.ui.platform.LocalResources

@Composable
fun rememberPuzzleThumbnail(
    puzzle: Puzzle,
    maxDimension: Int = THUMBNAIL_MAX_DIMENSION,
): ImageBitmap? {
    val resources = LocalResources.current
    val ioDispatcher: CoroutineDispatcher = koinInject(DispatchersQualifiers.IO)

    val thumbnail by produceState<ImageBitmap?>(initialValue = null, puzzle, maxDimension) {
        value = withContext(ioDispatcher) {
            loadPuzzleBitmap(resources, puzzle, maxDimension).asImageBitmap()
        }
    }
    return thumbnail
}
