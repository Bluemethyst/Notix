// desktopMain/kotlin/dev/bluemethyst/apps/notix/Fonts.kt
package dev.bluemethyst.apps.notix.ui

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.platform.Font
import java.io.File

actual fun getFontResource(resourceName: String): Font {
    val fontFile = File("src/desktopMain/resources/fonts/$resourceName.ttf")
    return Font(fontFile)
}