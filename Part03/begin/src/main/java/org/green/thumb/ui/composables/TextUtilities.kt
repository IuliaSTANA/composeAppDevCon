package org.green.thumb.ui.composables

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun convertTextToAnnotatedString(
    text: String,
    fontWeight: FontWeight = FontWeight.Bold,
    color: Color = MaterialTheme.typography.bodyLarge.color,
): AnnotatedString {
    val splitIndex = text.indexOf(":") + 1
    return if (splitIndex > 0) {
        val boldText = text.substring(0, splitIndex)
        val plainText = text.substring(splitIndex)
        with(AnnotatedString.Builder()) {
            pushStyle(SpanStyle(fontWeight = fontWeight, color = color))
            append(boldText)
            pop()
            append(" ")
            append(plainText)
            toAnnotatedString()
        }
    } else {
        AnnotatedString.Builder(text).toAnnotatedString()
    }
}