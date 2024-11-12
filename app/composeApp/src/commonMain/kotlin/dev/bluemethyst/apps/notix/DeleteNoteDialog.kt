package dev.bluemethyst.apps.notix

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DeleteNoteDialog(
    note: String, onDismiss: () -> Unit, onDeleteNote: () -> Unit, showDialog: Boolean
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
                    Text(
                        text = "Are you sure you want to delete this note?",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = onDismiss,
                            modifier = Modifier.padding(horizontal = 8.dp),
                            colors = ButtonColors(
                                containerColor = DarkColorPalette.onBackground,
                                contentColor = DarkColorPalette.background,
                                disabledContentColor = DarkColorPalette.onBackground,
                                disabledContainerColor = DarkColorPalette.background
                            )
                        ) {
                            Text(
                                "Cancel",
                                modifier = Modifier.width(70.dp),
                                textAlign = TextAlign.Center,
                                color = DarkColorPalette.secondary
                            )
                        }
                        Button(
                            onClick = onDeleteNote,
                            modifier = Modifier.padding(horizontal = 8.dp),
                            colors = ButtonColors(
                                containerColor = DarkColorPalette.primary,
                                contentColor = DarkColorPalette.background,
                                disabledContentColor = DarkColorPalette.onBackground,
                                disabledContainerColor = DarkColorPalette.background
                            )
                        ) {
                            Text(
                                "Delete",
                                modifier = Modifier.width(70.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}