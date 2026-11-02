package d7man.ristogreen.digital.ui.composable.screen.main_menu.content.buttons.secondary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import d7man.ristogreen.digital.ui.composable.shared.button.ActionButton
import d7man.ristogreen.digital.ui.composable.shared.button.ActionButtonItem
import d7man.ristogreen.digital.ui.theme.LocalDimens

@Composable
fun SecondaryButtons(
    recordsItem: ActionButtonItem,
    aboutItem: ActionButtonItem,
    onRecordsClick: () -> Unit,
    onAboutClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing),
    ) {
        ActionButton(
            item = recordsItem,
            onClick = onRecordsClick,
            modifier = Modifier.weight(1f),
        )
        ActionButton(
            item = aboutItem,
            onClick = onAboutClick,
            modifier = Modifier.weight(1f),
        )
    }
}
