package dev.bluemethyst.apps.notix

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun NewNoteDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    newNote: String,
    onNewNoteChange: (String) -> Unit,
    onAddNote: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    TextField(
                        value = newNote,
                        onValueChange = onNewNoteChange,
                        label = { Text("Note") },
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = onAddNote, colors = ButtonColors(
                            containerColor = DarkColorPalette.onBackground,
                            contentColor = DarkColorPalette.background,
                            disabledContentColor = DarkColorPalette.onBackground,
                            disabledContainerColor = DarkColorPalette.background
                        )
                    ) {
                        Text("Add Note", color = DarkColorPalette.secondary)
                    }
                }
            }
        }
    }
}