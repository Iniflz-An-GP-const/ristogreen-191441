package d7man.ristogreen.digital.ui.composable.screen.game.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import d7man.ristogreen.digital.ui.composable.screen.game.layout.TimerBlock

@Composable
fun GameLayout(
    isTimerVisible: Boolean,
    topBar: @Composable (extraAction: @Composable RowScope.() -> Unit) -> Unit,
    timer: @Composable () -> Unit,
    board: @Composable (Modifier) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        topBar {}

        board(Modifier
            .fillMaxWidth()
            .weight(1f))

        if (isTimerVisible) {
            TimerBlock { timer() }
        }
    }
}
