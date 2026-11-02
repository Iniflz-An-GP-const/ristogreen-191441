package d7man.ristogreen.digital.ui.composable.screen.main_menu

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import d7man.ristogreen.digital.ui.composable.screen.main_menu.content.MainMenuContent

@Composable
fun DIRILMainMenuScreen(
    onPuzzleSelectionScreenNavigation: () -> Unit,
    onGameRecordsScreenNavigation: () -> Unit,
    onAboutScreenNavigation: () -> Unit,
    onExit: () -> Unit,
    modifier: Modifier = Modifier,
) {
    MainMenuContent(
        modifier = modifier,
        onPuzzleSelectionScreenNavigation = onPuzzleSelectionScreenNavigation,
        onGameRecordsScreenNavigation = onGameRecordsScreenNavigation,
        onAboutScreenNavigation = onAboutScreenNavigation,
        onExit = onExit,
    )
}
