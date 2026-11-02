package d7man.ristogreen.digital.ui.theme.typography

import androidx.compose.ui.text.font.FontWeight
import d7man.ristogreen.digital.ui.theme.typography.Fonts
import d7man.ristogreen.digital.ui.theme.typography.googleFontFamily

val AppFonts = Fonts(
    body = googleFontFamily("Roboto"),
    display = googleFontFamily("Poppins"),
    displayWeight = FontWeight.SemiBold,
)
