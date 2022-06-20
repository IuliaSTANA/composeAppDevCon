package org.green.thumb.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.green.thumb.R
import org.green.thumb.data.Plant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantOverview(inventory: List<Plant>) =
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            //TODO: handle the FAB onclick by navigating to a new screen
        }) {
            Icon(Icons.Filled.Add, stringResource(id = R.string.add_plant))
        }
    }
    ) { paddingValues ->

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(paddingValues)
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
    }
