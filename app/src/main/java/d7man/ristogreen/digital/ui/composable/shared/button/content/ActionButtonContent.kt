package d7man.ristogreen.digital.ui.composable.shared.button.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import d7man.ristogreen.digital.ui.composable.shared.button.ActionButtonDefaults
import d7man.ristogreen.digital.ui.composable.shared.button.ActionButtonItem

@Composable
fun ActionButtonContent(
    item: ActionButtonItem,
    contentColor: Color,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(ActionButtonDefaults.iconTextSpacing),
    ) {
        Text(
            text = item.text,
            color = contentColor,
            style = ActionButtonDefaults.labelStyle(),
            textAlign = TextAlign.Center,
            maxLines = ActionButtonDefaults.LABEL_MAX_LINES,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f, fill = false),
        )
        Icon(
            imageVector = item.icon,
            contentDescription = null,
            tint = contentColor,
            modifier = Modifier.size(ActionButtonDefaults.IconSize),
        )
    }
}
