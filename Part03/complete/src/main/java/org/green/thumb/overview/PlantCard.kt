package org.green.thumb.overview

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.green.thumb.R
import org.green.thumb.data.Plant
import org.green.thumb.ui.theme.GreenThumbsTheme

@Composable
fun PlantCard(plant: Plant, modifier: Modifier = Modifier) = Column(modifier) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .clickable(onClick = { isExpanded = !isExpanded })
            .padding(horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_plant_fallback),
                //contentDescription is a mandatory parameter, cannot be omitted.
                contentDescription = null,
                colorFilter = ColorFilter.tint(
                    MaterialTheme.colorScheme.secondary,
                    BlendMode.SrcIn
                ),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(48.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = plant.name,
                    maxLines = if (isExpanded) 5 else 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .animateContentSize()
                )
                Text(
                    text = plant.location,
                    maxLines = if (isExpanded) 5 else 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .animateContentSize()
                )
            }
            Icon(
                imageVector = if (isExpanded) {
                    Icons.Filled.KeyboardArrowUp
                } else {
                    Icons.Filled.KeyboardArrowDown
                },
                contentDescription = "",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Column(
            modifier = Modifier
                .animateContentSize()
        ) {
            if (isExpanded) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(top = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        if (plant.careLog.isEmpty()) {
                            Text(
                                text = "No logs yet.",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = 4.dp),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        } else {
                            for (care in plant.careLog) {
                                Text(
                                    text = "${care.date}: ${care.description}",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 4.dp),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun PlantsOverview_Preview() {
    val longDescription = stringResource(id = R.string.lorem_ipsum)
    GreenThumbsTheme {
        PlantCard(Plant("Bob", longDescription, "hallway"))
    }
}
