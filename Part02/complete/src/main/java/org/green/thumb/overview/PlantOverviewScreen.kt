package org.green.thumb.overview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantOverviewScreen(viewModel: PlantOverviewViewModel, onAddPlant: () -> Unit) =
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = onAddPlant) {
            Icon(Icons.Filled.Add, stringResource(id = R.string.add_plant))
        }
    }
    ) { paddingValues ->

        val overviewUiState: OverviewData by viewModel.overviewData.observeAsState(OverviewData.Loading)

        PlantOverviewContent(overviewUiState = overviewUiState, modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth())

    }

@Composable
fun PlantOverviewContent(overviewUiState: OverviewData, modifier: Modifier = Modifier) {
    when (overviewUiState) {
        is OverviewData.Loading -> {
            OverviewLoading(modifier)
        }
        is OverviewData.Inventory -> {
            OverviewList(inventory = overviewUiState.plants, modifier = modifier)
        }
        is OverviewData.Error -> {
            OverviewError(modifier)
        }
    }
}

@Composable
fun OverviewList(inventory: List<Plant>, modifier: Modifier = Modifier) = LazyColumn(
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = modifier
        .fillMaxWidth()
) {
    item("header") {
        Text(
            text = stringResource(id = R.string.overview_title),
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
    }
    items(inventory) { plant ->
        PlantCard(plant)
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
    LinearProgressIndicator(modifier = Modifier
        .fillMaxWidth()
    )
}
