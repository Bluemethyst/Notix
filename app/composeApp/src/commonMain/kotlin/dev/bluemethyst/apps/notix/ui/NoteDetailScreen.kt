package dev.bluemethyst.apps.notix.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import dev.bluemethyst.apps.notix.Note
import dev.bluemethyst.apps.notix.icons.Arrow_back
import dev.bluemethyst.apps.notix.icons.Edit

@Composable
fun NoteDetailScreen(note: Note, onBack: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    println("edit note")
                },
                containerColor = DarkColorPalette.primary,
                contentColor = DarkColorPalette.background
            ) {
                Icon(Edit, contentDescription = "Edit Note")
            }
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize().background(DarkColorPalette.background)
                .padding(16.dp).padding(top = 32.dp)
        ) {
            Row {
                Icon(
                    Arrow_back,
                    contentDescription = "Back",
                    tint = DarkColorPalette.primary,
                    modifier = Modifier.clickable(onClick = onBack).padding(end = 16.dp).size(32.dp)
                )
                Text(
                    text = note.title,
                    fontFamily = letteraMonoLLFont,
                    fontSize = TextUnit(24F, TextUnitType.Sp),
                    color = DarkColorPalette.secondary,
                    modifier = Modifier.padding(bottom = 16.dp, top = 8.dp)
                )
            }
            Text(
                text = note.content,
                fontFamily = letteraMonoLLFont,
                fontSize = TextUnit(18F, TextUnitType.Sp),
                color = DarkColorPalette.secondary
            )
        }
    }
}