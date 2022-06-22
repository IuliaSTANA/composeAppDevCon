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
import org.green.thumb.ui.composables.convertTextToAnnotatedString
import org.green.thumb.ui.theme.*

@Composable
internal fun Page3() = Column(
    modifier = Modifier
        .fillMaxSize()
) {
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    Text(
        text = stringResource(id = R.string.instruction_maintenance_title),
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
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
            Text(
                text = convertTextToAnnotatedString(
                    text = stringResource(R.string.instruction_maintenance_misting),
                    color = MaterialTheme.colorScheme.primary
                ),
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(Modifier.height(SpacingSmall_BodyItems))
            Text(
                text = convertTextToAnnotatedString(
                    text = stringResource(R.string.instruction_maintenance_leaf),
                    color = MaterialTheme.colorScheme.primary
                ),
                style = MaterialTheme.typography.bodyLarge,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Keyline_Medium),
            ) {
                Text(
                    text = stringResource(R.string.instruction_maintenance_leaf1),
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(Modifier.height(Spacing_XSmall))
                Text(
                    text = stringResource(R.string.instruction_maintenance_leaf2),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }

            Spacer(Modifier.height(SpacingSmall_BodyItems))
            Text(
                text = convertTextToAnnotatedString(
                    text = stringResource(R.string.instruction_maintenance_fertilizer),
                    color = MaterialTheme.colorScheme.primary
                ),
                style = MaterialTheme.typography.bodyLarge,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Keyline_Medium),
            ) {
                Text(
                    text = stringResource(R.string.instruction_maintenance_fertilizer1),
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(Modifier.height(Spacing_XSmall))
                Text(
                    text = stringResource(R.string.instruction_maintenance_fertilizer2),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
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
private fun PageThree_Preview() {
    GreenThumbsTheme {
        Page3()
    }
}