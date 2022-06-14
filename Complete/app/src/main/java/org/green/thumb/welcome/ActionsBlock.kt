package org.green.thumb.welcome

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch
import org.green.thumb.Overview
import org.green.thumb.R
import org.green.thumb.ui.theme.GreenThumbsTheme
import org.green.thumb.ui.theme.PrimaryButtonWithFWArrow
import org.green.thumb.ui.theme.Spacing_XSmall
import org.green.thumb.ui.theme.TouchHeight

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun ActionsBlock(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navigate: (String) -> Unit = {},
) = Column(modifier) {
    val text = if (pagerState.currentPage.isLastPage()) {
        stringResource(id = R.string.board_button_start)
    } else {
        stringResource(id = R.string.board_button_next)
    }
    val scope = rememberCoroutineScope()

    PrimaryButtonWithFWArrow(text = text) {
        if (pagerState.currentPage.isLastPage()) {
            navigate(Overview)
        } else {
            scope.launch {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            }
        }
    }

    //only add the skip button while not on the last page
    if (pagerState.currentPage.isLastPage().not()) {
        Spacer(Modifier.height(Spacing_XSmall))
        TextButton(
            onClick = {
                navigate(Overview)
            },
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(minHeight = TouchHeight)
                .padding(horizontal = Spacing_XSmall)
        ) {
            Text(
                text = stringResource(id = R.string.board_button_skip),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

private fun Int.isLastPage(): Boolean = this == 3

@OptIn(ExperimentalPagerApi::class)
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun ActionsBlock_Preview() {
    GreenThumbsTheme {
        ActionsBlock(pagerState = PagerState(0))
    }
}