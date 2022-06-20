package org.green.thumb.welcome

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.green.thumb.R
import org.green.thumb.ui.composables.ImageTextRow
import org.green.thumb.ui.composables.convertTextToAnnotatedString
import org.green.thumb.ui.theme.GreenThumbsTheme
import org.green.thumb.ui.theme.Keyline_Small
import org.green.thumb.ui.theme.SpacingSmall_BodyItems

@Composable
internal fun PageTwo() = Column(
    modifier = Modifier
        .fillMaxSize()
) {
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    Text(
        text = stringResource(id = R.string.instruction_water_title),
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    )
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    ImageTextRow(text = stringResource(R.string.instruction_water_low), iconResourceId = R.drawable.ic_watering_low, modifier = Modifier.fillMaxWidth())
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    ImageTextRow(text = stringResource(R.string.instruction_water_moderate), iconResourceId = R.drawable.ic_watering_moderate, modifier = Modifier.fillMaxWidth())
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    ImageTextRow(text = stringResource(R.string.instruction_water_high), iconResourceId = R.drawable.ic_watering_high, modifier = Modifier.fillMaxWidth())
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    ImageTextRow(text = stringResource(R.string.instruction_water_misting), iconResourceId = R.drawable.ic_watering_misting, modifier = Modifier.fillMaxWidth())
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 2.dp,
        tonalElevation = 1.dp,
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(Keyline_Small)) {
            Text(
                text = convertTextToAnnotatedString(
                    text = stringResource(R.string.instruction_water_tip1),
                    color = MaterialTheme.colorScheme.primary
                ),
            )
            Spacer(modifier = Modifier.height(SpacingSmall_BodyItems))
            Text(
                text = convertTextToAnnotatedString(
                    text = stringResource(R.string.instruction_water_tip2),
                    color = MaterialTheme.colorScheme.primary
                ),
            )
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
private fun PageTwo_Preview() {
    GreenThumbsTheme {
        PageTwo()
    }
}