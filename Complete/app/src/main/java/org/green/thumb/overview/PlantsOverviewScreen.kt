package org.green.thumb.overview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.green.thumb.ui.composables.Logo
import org.green.thumb.ui.theme.Keyline_Large
import org.green.thumb.ui.theme.Keyline_Medium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantsOverviewScreen(
    windowSize: WindowWidthSizeClass
) =
    Scaffold { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = when (windowSize) {
                    WindowWidthSizeClass.Compact -> Keyline_Medium
                    else -> Keyline_Large
                })
        ) {
            Logo(
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }