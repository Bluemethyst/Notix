package dev.bluemethyst.apps.notix.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun NewNoteDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    newNoteTitle: String,
    onNewNoteTitleChange: (String) -> Unit,
    newNoteContent: String,
    onNewNoteContentChange: (String) -> Unit,
    onAddNote: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardColorPalette
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = newNoteTitle,
                        onValueChange = onNewNoteTitleChange,
                        label = { Text("Title") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldColorPalette
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = newNoteContent,
                        onValueChange = onNewNoteContentChange,
                        label = { Text("Content") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldColorPalette
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = onDismiss,
                            border = ButtonDefaults.outlinedButtonBorder(),
                            modifier = Modifier.padding(horizontal = 8.dp).weight(0.4F),
                            colors = ButtonColorPalette
                        ) {
                            Text(
                                "Cancel",
                                textAlign = TextAlign.Center,
                                color = DarkColorPalette.secondary
                            )
                        }
                        Button(
                            onClick = onAddNote,
                            modifier = Modifier.padding(horizontal = 8.dp).weight(0.4F),
                            colors = RedButtonColorPalette
                        ) {
                            Text(
                                "Add Note",
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}