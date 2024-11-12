// androidMain/kotlin/dev/bluemethyst/apps/notix/Fonts.android.kt
package dev.bluemethyst.apps.notix

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight

actual fun getFontResource(resourceName: String): Font {
    return when (resourceName) {
        "lettera_mono_ll_regular" -> Font(R.font.lettera_mono_ll_regular, FontWeight.Normal)
        "lettera_mono_ll_condlight_regular" -> Font(R.font.lettera_mono_ll_condlight_regular, FontWeight.Bold)
        "nothing_dot_matrix" -> Font(R.font.nothing_dot_matrix, FontWeight.Normal)
        else -> throw IllegalArgumentException("Unknown font resource: $resourceName")
    }
}