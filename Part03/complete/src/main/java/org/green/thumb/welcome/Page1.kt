package org.green.thumb.welcome

import android.content.res.Configuration
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.green.thumb.R
import org.green.thumb.ui.composables.IconTextRow
import org.green.thumb.ui.composables.convertTextToAnnotatedString
import org.green.thumb.ui.theme.GreenThumbsTheme
import org.green.thumb.ui.theme.Keyline_Small
import org.green.thumb.ui.theme.SpacingSmall_BodyItems
import org.green.thumb.ui.theme.Spacing_XSmall

@Composable
internal fun Page1() = Column(
    modifier = Modifier
        .fillMaxSize()
) {
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    Text(
        text = stringResource(id = R.string.instruction_light_title),
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    )
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    IconTextRow(stringResource(id = R.string.instruction_light_direct))
    Spacer(Modifier.height(Spacing_XSmall))
    IconTextRow(stringResource(id = R.string.instruction_light_indirect))
    Spacer(Modifier.height(Spacing_XSmall))
    IconTextRow(stringResource(id = R.string.instruction_light_low))
    Spacer(Modifier.height(SpacingSmall_BodyItems))

    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 2.dp,
        tonalElevation = 1.dp,
    ) {
        Text(
            text = convertTextToAnnotatedString(
                text = stringResource(id = R.string.instruction_light_tip),
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(Keyline_Small),
            style = MaterialTheme.typography.bodyLarge
        )
    }
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            repeatMode = RepeatMode.Reverse
        )
    )
    Spacer(Modifier.height(SpacingSmall_BodyItems))
    Image(
        painter = painterResource(id = R.drawable.ic_light_sun),
        modifier = Modifier
            .align(Alignment.CenterHorizontally),
        contentDescription = null, // decorative element
        alpha = alpha
    )
    Image(
        painter = painterResource(id = R.drawable.ic_light_plant),
        modifier = Modifier.align(Alignment.CenterHorizontally),
        contentDescription = null,
    )
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun PageOne_Preview() {
    GreenThumbsTheme {
        Page1()
    }
}