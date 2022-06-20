package org.green.thumb.overview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.green.thumb.R
import org.green.thumb.data.Plant
import org.green.thumb.ui.composables.LazyStaggeredGrid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantOverviewScreen(
    viewModel: PlantOverviewViewModel,
    windowSize: WindowWidthSizeClass,
    onAddPlant: () -> Unit
) =
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = onAddPlant,
            modifier = Modifier
                .systemBarsPadding()
                .navigationBarsPadding(),
            contentColor = MaterialTheme.colorScheme.onPrimary,
            backgroundColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(Icons.Filled.Add, stringResource(id = R.string.add_plant))
        }
    }
    ) { paddingValues ->

        val overviewUiState: OverviewData by viewModel.overviewData.observeAsState(OverviewData.Loading)

        PlantOverviewContent(
            overviewUiState = overviewUiState,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            windowSize = windowSize
        )

    }

@Composable
fun PlantOverviewContent(
    overviewUiState: OverviewData,
    modifier: Modifier = Modifier,
    windowSize: WindowWidthSizeClass
) {
    Column {
        Text(
            text = stringResource(id = R.string.overview_title),
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(bottom = 16.dp)
        )
        when (overviewUiState) {
            is OverviewData.Loading -> {
                OverviewLoading(modifier)
            }
            is OverviewData.Inventory -> {
                OverviewList(
                    inventory = overviewUiState.plants,
                    modifier = modifier
                        .systemBarsPadding()
                        .navigationBarsPadding(),
                    windowSize = windowSize
                )
            }
            is OverviewData.Error -> {
                OverviewError(modifier)
            }
        }
    }
}

@Composable
fun OverviewList(
    inventory: List<Plant>,
    modifier: Modifier = Modifier,
    windowSize: WindowWidthSizeClass
) =
    when (windowSize) {
        WindowWidthSizeClass.Expanded -> OverviewListGrid(inventory, modifier, 3)
        WindowWidthSizeClass.Medium -> OverviewListGrid(inventory, modifier, 2)
        else -> OverviewListCompact(inventory, modifier)
    }

@Composable
fun OverviewListGrid(inventory: List<Plant>, modifier: Modifier = Modifier, columnCount: Int = 2) =
    LazyStaggeredGrid(
        modifier = modifier,
        contentPadding = PaddingValues(bottom = 64.dp), // Accommodate space for FAB
        columnCount = columnCount
    ) {
        inventory.forEach { plant ->
            item {
                PlantCard(plant)
            }
        }
    }

@Composable
fun OverviewListCompact(inventory: List<Plant>, modifier: Modifier = Modifier) = LazyVerticalGrid(
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = modifier.fillMaxWidth(),
    contentPadding = PaddingValues(bottom = 56.dp), // Accommodate space for FAB
    columns = GridCells.Adaptive(minSize = 320.dp)
) {
    items(inventory.size) { i ->
        PlantCard(inventory[i])
    }
}

@Composable
fun OverviewError(modifier: Modifier) = Column(modifier.padding(16.dp)) {
    Spacer(Modifier.height(56.dp))
    Text(
        text = stringResource(id = R.string.overview_title_error),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
fun OverviewLoading(modifier: Modifier) = Column(modifier.padding(16.dp)) {
    Spacer(Modifier.height(56.dp))
    Text(
        text = stringResource(id = R.string.overview_title_loading),
        style = MaterialTheme.typography.headlineLarge,
    )
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
    )
}
