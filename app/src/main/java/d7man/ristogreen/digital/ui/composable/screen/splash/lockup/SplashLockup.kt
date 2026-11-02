package d7man.ristogreen.digital.ui.composable.screen.splash.lockup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import d7man.ristogreen.digital.ui.theme.LocalDimens

private val LogoSize = 144.dp

@Composable
fun SplashLockup(
    logo: @Composable (size: Dp) -> Unit,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    Column(
        modifier = modifier.padding(horizontal = dimens.screenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        logo(LogoSize)

        Spacer(modifier = Modifier.height(dimens.contentSpacing))

        title()
    }
}
