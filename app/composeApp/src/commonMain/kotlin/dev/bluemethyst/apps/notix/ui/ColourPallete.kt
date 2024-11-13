package dev.bluemethyst.apps.notix.ui

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color

val DarkColorPalette = darkColorScheme(
    background = Color(0xFF000000),
    onBackground = Color(0xFF14151F),
    primary = Color(0xFFd71921),
    secondary = Color(0xFFDCDCDC),
)

val CardColorPalette = CardColors(
    containerColor = DarkColorPalette.onBackground,
    contentColor = DarkColorPalette.secondary,
    disabledContentColor = DarkColorPalette.onBackground,
    disabledContainerColor = DarkColorPalette.background
)

val ButtonColorPalette = ButtonColors(
    containerColor = DarkColorPalette.onBackground,
    contentColor = DarkColorPalette.background,
    disabledContentColor = DarkColorPalette.onBackground,
    disabledContainerColor = DarkColorPalette.background
)

val RedButtonColorPalette = ButtonColors(
    containerColor = DarkColorPalette.primary,
    contentColor = DarkColorPalette.background,
    disabledContentColor = DarkColorPalette.onBackground,
    disabledContainerColor = DarkColorPalette.background
)

//val ss = OutlinedTextFieldDefaults
val TextFieldColorPalette = TextFieldColors(
    focusedTextColor = DarkColorPalette.secondary,
    unfocusedTextColor = DarkColorPalette.secondary,
    disabledTextColor = DarkColorPalette.secondary,
    errorTextColor = Color.Red,
    focusedContainerColor = DarkColorPalette.onBackground,
    unfocusedContainerColor = DarkColorPalette.onBackground,
    disabledContainerColor = DarkColorPalette.onBackground,
    errorContainerColor = Color.Red,
    cursorColor = DarkColorPalette.primary,
    errorCursorColor = DarkColorPalette.primary,
    focusedLeadingIconColor = Color.Unspecified,
    unfocusedLeadingIconColor = Color.Unspecified,
    disabledLeadingIconColor = Color.Unspecified,
    errorLeadingIconColor = Color.Unspecified,
    focusedTrailingIconColor = Color.Unspecified,
    unfocusedTrailingIconColor = Color.Unspecified,
    disabledTrailingIconColor = Color.Unspecified,
    errorTrailingIconColor = Color.Unspecified,
    focusedLabelColor = DarkColorPalette.secondary,
    unfocusedLabelColor = DarkColorPalette.secondary,
    disabledLabelColor = DarkColorPalette.secondary,
    errorLabelColor = Color.Red,
    focusedPlaceholderColor = Color.Unspecified,
    unfocusedPlaceholderColor = Color.Unspecified,
    disabledPlaceholderColor = Color.Unspecified,
    errorPlaceholderColor = Color.Unspecified,
    focusedSupportingTextColor = Color.Unspecified,
    unfocusedSupportingTextColor = Color.Unspecified,
    disabledSupportingTextColor = Color.Unspecified,
    errorSupportingTextColor = Color.Red,
    focusedPrefixColor = Color.Unspecified,
    unfocusedPrefixColor = Color.Unspecified,
    disabledPrefixColor = Color.Unspecified,
    errorPrefixColor = Color.Unspecified,
    focusedSuffixColor = Color.Unspecified,
    unfocusedSuffixColor = Color.Unspecified,
    disabledSuffixColor = Color.Unspecified,
    textSelectionColors = TextSelectionColors(
        handleColor = Color.Unspecified,
        backgroundColor = Color.Unspecified
    ),
    focusedIndicatorColor = DarkColorPalette.primary,
    unfocusedIndicatorColor = DarkColorPalette.secondary,
    disabledIndicatorColor = DarkColorPalette.secondary,
    errorIndicatorColor = Color.Red,
    errorSuffixColor = Color.Unspecified,
)