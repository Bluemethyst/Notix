// NoteApp.kt
package dev.bluemethyst.apps.notix

import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import dev.bluemethyst.apps.notix.icons.Arrow_outward
import dev.bluemethyst.apps.notix.icons.Delete
import dev.bluemethyst.apps.notix.ui.CardColorPalette
import dev.bluemethyst.apps.notix.ui.DarkColorPalette
import dev.bluemethyst.apps.notix.ui.DeleteNoteDialog
import dev.bluemethyst.apps.notix.ui.NewNoteDialog
import dev.bluemethyst.apps.notix.ui.NoteDetailScreen
import dev.bluemethyst.apps.notix.ui.letteraMonoLLFont
import dev.bluemethyst.apps.notix.ui.nothingDotMatrixFont
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    MaterialTheme(
        colorScheme = DarkColorPalette
    ) {


        var notes by remember {
            mutableStateOf(
                listOf(
                    Note(
                        title = "Note 1",
                        content = "Content of Note 1"
                    ),
                    Note(
                        title = "Note 2",
                        content = "Content of Note 2"
                    )
                )
            )
        }
        var newNoteTitle by remember { mutableStateOf("") }
        var newNoteContent by remember { mutableStateOf("") }
        var showNewNoteDialog by remember { mutableStateOf(false) }
        var showDeleteNoteDialog by remember { mutableStateOf(false) }
        var noteToDelete by remember { mutableStateOf<Note?>(null) }
        var selectedNote by remember { mutableStateOf<Note?>(null) }

        if (selectedNote != null) {
            NoteDetailScreen(
                note = selectedNote!!,
                onBack = { selectedNote = null }
            )
        } else {
            NewNoteDialog(
                showDialog = showNewNoteDialog,
                onDismiss = { showNewNoteDialog = false },
                newNoteTitle = newNoteTitle,
                onNewNoteTitleChange = { newNoteTitle = it },
                newNoteContent = newNoteContent,
                onNewNoteContentChange = { newNoteContent = it },
                onAddNote = {
                    if (newNoteTitle.isNotEmpty() && newNoteContent.isNotEmpty()) {
                        notes = notes + Note(
                            title = newNoteTitle,
                            content = newNoteContent
                        )
                        newNoteTitle = ""
                        newNoteContent = ""
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
                        containerColor = DarkColorPalette.primary,
                        contentColor = DarkColorPalette.background
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
                            fontSize = TextUnit(48F, TextUnitType.Sp),
                            modifier = Modifier.padding(bottom = 16.dp).fillMaxWidth()
                        )
                        LazyColumn {
                            if (notes.isEmpty()) {
                                item {
                                    Text(
                                        text = "You've not added any notes yet!",
                                        color = DarkColorPalette.secondary,
                                        fontFamily = letteraMonoLLFont,
                                        fontSize = TextUnit(18F, TextUnitType.Sp),
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(16.dp).fillMaxWidth()
                                            .fillMaxHeight()
                                    )
                                    Text(
                                        text = "Click the little + to add a new note",
                                        color = DarkColorPalette.secondary,
                                        fontFamily = letteraMonoLLFont,
                                        fontSize = TextUnit(14F, TextUnitType.Sp),
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(16.dp).fillMaxWidth()
                                            .fillMaxHeight()
                                    )
                                    Icon(
                                        Arrow_outward,
                                        tint = DarkColorPalette.primary,
                                        contentDescription = "Arrow Outward",
                                        modifier = Modifier.rotate(90F).padding(16.dp)
                                            .fillMaxWidth()
                                            .fillMaxHeight()
                                    )
                                }
                            }
                            items(notes) { note ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp)
                                        .clickable { selectedNote = note },
                                    colors = CardColorPalette
                                ) {
                                    Row {
                                        Column(
                                            modifier = Modifier.weight(1f).padding(18.dp)
                                        ) {
                                            Text(
                                                text = note.title,
                                                fontFamily = letteraMonoLLFont,
                                                fontSize = TextUnit(18F, TextUnitType.Sp),
                                                color = DarkColorPalette.secondary
                                            )
                                            Spacer(
                                                modifier = Modifier.height(2.dp).fillMaxWidth()
                                                    .background(DarkColorPalette.secondary)
                                            )
                                            Text(
                                                text = note.content,
                                                fontFamily = letteraMonoLLFont,
                                                color = DarkColorPalette.secondary,
                                                modifier = Modifier.padding(top = 8.dp),
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                        Icon(
                                            Delete,
                                            tint = DarkColorPalette.primary,
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
}

@Preview
@Composable
fun NoteAppPreview() {
    App()
}