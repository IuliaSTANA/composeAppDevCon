package org.green.thumb.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import org.green.thumb.R
import org.green.thumb.ui.theme.GreenThumbsTheme
import org.green.thumb.ui.theme.SpacingXXLarge_TopEdgeToLogo


@Composable
fun Logo(modifier: Modifier = Modifier) = Column(modifier = modifier) {
    Spacer(Modifier.height(SpacingXXLarge_TopEdgeToLogo))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            text = stringResource(R.string.app_name),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
        )
        Image(
            painter = painterResource(R.drawable.ic_greenthumb_logo),
            contentDescription = stringResource(R.string.ic_logo_description),
            modifier = Modifier.height(TextFieldDefaults.MinHeight)
        )
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun LogoPreview() {
    GreenThumbsTheme {
        Logo()
    }
}