package org.green.thumb.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight


/**
 * Composable emitting the styled primary button with a minimum height of 48dp with a padding of 8dp,
 * full width (to be expanded so it allows varying widths at a later time)
 *
 * @param text: The button's label
 * @param onClick: what happens when the button is clicked
 * */
@Composable
fun PrimaryButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier
            .sizeIn(minHeight = TouchHeight)
            .padding(horizontal = Spacing_XSmall)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/**
 * Composable emitting the styled primary button where it's label is postfixed with a forward arrow
 * @see [PrimaryButton]
 *
 * @param text: The button's label
 * @param onClick: what happens when the button is clicked
 * */
@Composable
fun PrimaryButtonWithFWArrow(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .sizeIn(minHeight = TouchHeight)
            .padding(horizontal = Spacing_XSmall),
        enabled = enabled
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Icon(
            Icons.Filled.ArrowForward,
            contentDescription = "",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
    }
}