package org.green.thumb.overview

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.green.thumb.R
import org.green.thumb.data.Plant
import org.green.thumb.ui.composables.StaggeredVerticalGrid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantOverviewScreen(
    viewModel: PlantOverviewViewModel,
    windowSize: WindowWidthSizeClass,
    onAddPlant: () -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedDestination = PlantOviewviewDestinations.INVENTORY

    if (windowSize == WindowWidthSizeClass.Expanded) {
        PermanentNavigationDrawer(
            drawerContent = {
                PlantOverviewNavDrawerContent(
                    selectedDestination
                )
            },
            modifier = Modifier.systemBarsPadding(),
            content = {
                PlantOverviewInner(
                    viewModel, windowSize, onAddPlant,
                    selectedDestination
                )
            }
        )
    } else {
        ModalNavigationDrawer(
            drawerContent = {
                PlantOverviewNavDrawerContent(
                    selectedDestination,
                    onDrawerClick = {
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )
            },
            drawerState = drawerState,
            content = {
                PlantOverviewInner(viewModel, windowSize, onAddPlant,
                    selectedDestination,
                    onDrawerClicked = {
                        scope.launch {
                            drawerState.open()
                        }
                    })
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PlantOverviewInner(
    viewModel: PlantOverviewViewModel,
    windowSize: WindowWidthSizeClass,
    onAddPlant: () -> Unit,
    selectedDestination: PlantOviewviewDestinations,
    onDrawerClicked: () -> Unit = {}
) = Row(
    modifier = Modifier
        .systemBarsPadding()
        .fillMaxSize()
) {
    AnimatedVisibility(visible = windowSize == WindowWidthSizeClass.Medium) {
        PlantOverviewNavRailContent(selectedDestination, onDrawerClicked)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = onAddPlant,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    backgroundColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(Icons.Filled.Add, stringResource(id = R.string.add_plant))
                }
            },
            modifier = Modifier
                .weight(1f)
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
        AnimatedVisibility(visible = windowSize == WindowWidthSizeClass.Compact) {
            PlantOverviewNavBarContent(selectedDestination)
        }
    }
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
                    modifier = modifier,
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
    StaggeredVerticalGrid(
        maxColumnWidth = 360.dp,
        modifier = modifier
            .padding(horizontal = 8.dp)
    ) {
        inventory.forEach { plant ->
            PlantCard(plant, collapsable = false)
        }
    }

//@Composable
//fun OverviewListGrid(inventory: List<Plant>, modifier: Modifier = Modifier, columnCount: Int = 2) =
//    LazyStaggeredGrid(
//        modifier = modifier.padding(horizontal = 8.dp),
//        contentPadding = PaddingValues(bottom = 64.dp), // Accommodate space for FAB
//        columnCount = columnCount
//    ) {
//        inventory.forEach { plant ->
//            item {
//                PlantCard(plant)
//            }
//        }
//    }

//@Composable
//fun OverviewListGrid(inventory: List<Plant>, modifier: Modifier = Modifier) = LazyVerticalGrid(
//    verticalArrangement = Arrangement.spacedBy(16.dp),
//    modifier = modifier
//        .fillMaxWidth()
//        .padding(horizontal = 8.dp),
//    contentPadding = PaddingValues(bottom = 56.dp), // Accommodate space for FAB
//    columns = GridCells.Adaptive(minSize = 320.dp)
//) {
//    items(inventory.size) { i ->
//        PlantCard(inventory[i])
//    }
//}

@Composable
fun OverviewListCompact(inventory: List<Plant>, modifier: Modifier = Modifier) = LazyColumn(
    modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp),
    contentPadding = PaddingValues(bottom = 56.dp) // Accommodate space for FAB
) {
    items(inventory) { plant ->
        PlantCard(plant, collapsable = true)
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
