package org.green.thumb.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.green.thumb.ui.theme.GreenThumbsTheme
import org.green.thumb.ui.theme.Keyline_Medium

@Composable
fun IconTextRow(text: String, modifier: Modifier = Modifier) = Row(
    modifier,
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.CenterVertically
) {
    Icon(
        imageVector = Icons.Outlined.CheckCircle,
        contentDescription = "",
        modifier = Modifier.size(24.dp),
        tint = MaterialTheme.colorScheme.primary
    )
    Spacer(Modifier.width(Keyline_Medium))
    val splitIndex = text.indexOf(":") + 1
    val styledText = if (splitIndex > 0) {
        val boldText = text.substring(0, splitIndex)
        val plainText = text.substring(splitIndex)
        with(AnnotatedString.Builder()) {
            pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
            append(boldText)
            pop()
            append(" ")
            append(plainText)
            toAnnotatedString()
        }
    } else {
        AnnotatedString.Builder(text).toAnnotatedString()
    }

    Text(
        text = styledText,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
    )
}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun IconTextRow_Preview() {
    GreenThumbsTheme {
        IconTextRow("Direct (bright): full sunlight for 6+ hours per day.")
    }
}