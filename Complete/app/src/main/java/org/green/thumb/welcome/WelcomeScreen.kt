package org.green.thumb.welcome

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import org.green.thumb.R
import org.green.thumb.ui.composables.Logo
import org.green.thumb.ui.composables.Title
import org.green.thumb.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navigate: (String) -> Unit = {},
    windowSize: WindowWidthSizeClass,
) =
    Scaffold { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = when (windowSize) {
                    WindowWidthSizeClass.Compact -> Keyline_Medium
                    else -> Keyline_Large
                })
                .navigationBarsPadding()
        ) {
            Logo(
                modifier = Modifier
                    .fillMaxWidth()
            )
            Title(
                title = stringResource(R.string.welcome_title),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(SpacingLarge_TitleToBody))
            Text(
                text = stringResource(R.string.welcome_description),
                style = MaterialTheme.typography.bodyLarge,
            )
            val pagerState = rememberPagerState()
            HorizontalPager(
                count = 4,
                state = pagerState,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
            ) { page ->
                PagerItem(
                    page = page,
                )
            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
            )

            ActionsBlock(
                pagerState = pagerState,
                navigate = navigate,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.height(SpacingMedium_FooterToBottomEdge))
        }
    }


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun Welcome_Preview() {
    GreenThumbsTheme {
        WelcomeScreen(
            windowSize = WindowWidthSizeClass.Compact
        )
    }
}

@Preview(name = "Light Mode", widthDp = 700)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    widthDp = 700
)
@Composable
private fun Welcome_Preview_Tablet() {
    GreenThumbsTheme {
        WelcomeScreen(
            windowSize = WindowWidthSizeClass.Medium
        )
    }
}
