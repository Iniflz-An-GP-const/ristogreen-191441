package d7man.ristogreen.digital.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import d7man.ristogreen.digital.ui.theme.dimens.AppDimens
import d7man.ristogreen.digital.ui.theme.motion.AppMotion
import d7man.ristogreen.digital.ui.theme.typography.appTypography
import d7man.ristogreen.digital.ui.theme.typography.AppFonts
import d7man.ristogreen.digital.ui.theme.AppPalette

fun Palette.toColorScheme(): ColorScheme = lightColorScheme(
    primary = primary,
    onPrimary = onPrimary,

    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,

    secondary = secondary,
    onSecondary = onSecondary,

    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,

    tertiary = tertiary,
    onTertiary = onTertiary,

    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,

    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,

    background = background,
    onBackground = onBackground,

    surface = surface,
    onSurface = onSurface,

    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,

    surfaceTint = surfaceTint,
    surfaceDim = surfaceDim,
    surfaceBright = surfaceBright,

    surfaceContainerLowest = surfaceContainerLowest,
    surfaceContainerLow = surfaceContainerLow,
    surfaceContainer = surfaceContainer,
    surfaceContainerHigh = surfaceContainerHigh,
    surfaceContainerHighest = surfaceContainerHighest,

    outline = outline,
    outlineVariant = outlineVariant,

    inverseSurface = inverseSurface,
    inverseOnSurface = inverseOnSurface,
    inversePrimary = inversePrimary,

    scrim = scrim
)

private val LightColorScheme = AppPalette.toColorScheme()

val LocalDimens = staticCompositionLocalOf { AppDimens }

val LocalMotion = staticCompositionLocalOf { AppMotion }

private val AppTypography = appTypography(AppFonts)

@Composable
fun DIRILAppTheme(
    colorScheme: ColorScheme = LightColorScheme,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalDimens provides AppDimens,
        LocalMotion provides AppMotion,
    ) {

        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }
}