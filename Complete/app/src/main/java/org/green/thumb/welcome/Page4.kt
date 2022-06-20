package org.green.thumb.welcome

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.green.thumb.R
import org.green.thumb.ui.composables.ImageTextRow
import org.green.thumb.ui.theme.GreenThumbsTheme
import org.green.thumb.ui.theme.Keyline_Small
import org.green.thumb.ui.theme.SpacingSmall_BodyItems

@Composable
internal fun Page4() = Column(
    modifier = Modifier
        .fillMaxSize()
) {
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    Text(
        text = stringResource(id = R.string.instruction_consistency_title),
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    )
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    Text(
        text = stringResource(R.string.instruction_consistency_description),
        style = MaterialTheme.typography.bodyLarge,
    )
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 2.dp,
        tonalElevation = 1.dp,
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(Keyline_Small)) {
            ImageTextRow(text = stringResource(R.string.instruction_consistency_watering), iconResourceId = R.drawable.ic_consistency_watering, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(SpacingSmall_BodyItems))
            ImageTextRow(text = stringResource(R.string.instruction_consistency_temperature), iconResourceId = R.drawable.ic_consistency_temperature, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(SpacingSmall_BodyItems))
            ImageTextRow(text = stringResource(R.string.instruction_consistency_fertilizer), iconResourceId = R.drawable.ic_consistency_fertilizer, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(SpacingSmall_BodyItems))
            ImageTextRow(text = stringResource(R.string.instruction_consistency_light), iconResourceId = R.drawable.ic_consistency_light, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(SpacingSmall_BodyItems))
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun PageFour_Preview() {
    GreenThumbsTheme {
        Page4()
    }
}