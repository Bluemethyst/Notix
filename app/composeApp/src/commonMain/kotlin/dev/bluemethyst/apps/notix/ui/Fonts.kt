// commonMain/kotlin/dev/bluemethyst/apps/notix/Fonts.kt
package dev.bluemethyst.apps.notix.ui

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

expect fun getFontResource(resourceName: String): Font

val letteraMonoLLFont = FontFamily(
    getFontResource("lettera_mono_ll_regular"),
    getFontResource("lettera_mono_ll_condlight_regular")
)

val nothingDotMatrixFont = FontFamily(
    getFontResource("nothing_dot_matrix")
)