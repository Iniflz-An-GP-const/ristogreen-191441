package d7man.ristogreen.digital.ui.composable.screen.game_records.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import d7man.ristogreen.digital.R
import d7man.ristogreen.digital.ui.composable.screen.game_records.card.GameRecordCardDefaults
import d7man.ristogreen.digital.ui.composable.screen.game_records.card.GameRecordCardItem
import d7man.ristogreen.digital.ui.theme.LocalDimens
import d7man.ristogreen.digital.ui.theme.cardBorderStroke

private val BadgeSize = 48.dp

@Composable
fun GameRecordCard(
    item: GameRecordCardItem,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val shape = GameRecordCardDefaults.shape
    val border = cardBorderStroke()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(color = MaterialTheme.colorScheme.surfaceContainer, shape = shape)
            .let { base -> if (border != null) base.border(border, shape) else base }
            .padding(GameRecordCardDefaults.padding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing),
    ) {
        Box(
            modifier = Modifier
                .size(BadgeSize)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = stringResource(R.string.game_record_card_rank_format, item.rank),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(dimens.tightSpacing)) {
            Text(
                text = stringResource(
                    R.string.game_record_card_score_format,
                    item.puzzleTitle,
                    item.formattedTime
                ),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Text(
                text = item.formattedDate,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
