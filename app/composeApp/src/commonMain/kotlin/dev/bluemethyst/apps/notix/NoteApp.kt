// NoteApp.kt
package dev.bluemethyst.apps.notix

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.bluemethyst.apps.notix.api.getNotes
import dev.bluemethyst.apps.notix.icons.Delete
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    MaterialTheme(colorScheme = DarkColorPalette) {
        var notes by remember {
            mutableStateOf(
                listOf(
                    "Note 1",
                    "Note 2",
                    "Note 3",
                    "Note 4",
                    "note 5",
                    "Note 6"
                )
            )
        }
        var newNote by remember { mutableStateOf("") }
        var showNewNoteDialog by remember { mutableStateOf(false) }
        var showDeleteNoteDialog by remember { mutableStateOf(false) }
        var noteToDelete by remember { mutableStateOf<String?>(null) }

        NewNoteDialog(
            showDialog = showNewNoteDialog,
            onDismiss = { showNewNoteDialog = false },
            newNote = newNote,
            onNewNoteChange = { newNote = it },
            onAddNote = {
                if (newNote.isNotEmpty()) {
                    notes = notes + newNote
                    newNote = ""
                    showNewNoteDialog = false
                }
            }
        )

        noteToDelete?.let { note ->
            DeleteNoteDialog(
                note = note,
                onDismiss = { showDeleteNoteDialog = false },
                onDeleteNote = {
                    notes = notes - note
                    showDeleteNoteDialog = false
                    noteToDelete = null
                },
                showDialog = showDeleteNoteDialog
            )
        }

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        showNewNoteDialog = true
                    },
                    containerColor = DarkColorPalette.primary
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add Note")
                }
            },
            content = { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(16.dp)
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Notix",
                        color = DarkColorPalette.secondary,
                        fontFamily = nothingDotMatrixFont,
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    LazyColumn {
                        items(notes) { note ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                colors = CardColors(
                                    containerColor = DarkColorPalette.onBackground,
                                    contentColor = DarkColorPalette.background,
                                    disabledContentColor = DarkColorPalette.onBackground,
                                    disabledContainerColor = DarkColorPalette.background
                                )
                            ) {
                                Row {
                                    Text(
                                        text = note,
                                        fontFamily = letteraMonoLLFont,
                                        color = DarkColorPalette.secondary,
                                        modifier = Modifier.weight(1f).padding(18.dp)
                                    )
                                    Icon(
                                        Delete,
                                        tint = DarkColorPalette.secondary,
                                        contentDescription = "Delete",
                                        modifier = Modifier
                                            .padding(16.dp).width(20.dp).clickable(onClick = {
                                                noteToDelete = note
                                                showDeleteNoteDialog = true
                                            })
                                    )
                                }
                            }
                        }
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun NoteAppPreview() {
    App()
}