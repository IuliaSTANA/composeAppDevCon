package org.green.thumb.welcome

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.green.thumb.ui.theme.GreenThumbsTheme

@Composable
internal fun PagerItem(page: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        when {
            page.isFirst() -> Page1()
            page.isSecond() -> Page2()
            page.isThird() -> Page3()
            page.isFourth() -> Page4()
        }
    }
}


private fun Int.isFirst(): Boolean = this == 0
private fun Int.isSecond(): Boolean = this == 1
private fun Int.isThird(): Boolean = this == 2
private fun Int.isFourth(): Boolean = this == 3

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun PagerItem_Preview() {
    GreenThumbsTheme {
        PagerItem(0)
    }
}