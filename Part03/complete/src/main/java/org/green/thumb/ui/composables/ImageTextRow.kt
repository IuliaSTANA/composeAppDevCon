package org.green.thumb.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import org.green.thumb.ui.theme.Keyline_Medium

@Composable
fun ImageTextRow(text: String, iconResourceId: Int, modifier: Modifier) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconResourceId),
            contentDescription = null, // decorative element
        )
        Spacer(Modifier.width(Keyline_Medium))
        Text(
            text = convertTextToAnnotatedString(text = text),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
        )
    }
}
