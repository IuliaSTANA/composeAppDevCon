package org.green.thumb.overview

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.green.SampleData
import org.green.thumb.data.Plant
import org.green.thumb.ui.composables.Logo
import org.green.thumb.ui.theme.GreenThumbsTheme
import org.green.thumb.ui.theme.Keyline_Medium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantsOverviewScreen(
) =
    Scaffold { _ ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = Keyline_Medium)
        ) {
            Logo(
                modifier = Modifier
                    .fillMaxWidth()
            )
            PlantInventory(SampleData.plantSample)
        }
    }

@Composable
fun PlantInventory(messages: List<Plant>) {
    LazyColumn {
        items(messages) { message ->
            PlantCard(message)
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
private fun PlantsOverview_Preview() {
    GreenThumbsTheme {
        PlantsOverviewScreen()
    }
}