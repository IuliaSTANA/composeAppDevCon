package org.green.thumb.overview

import androidx.compose.animation.animateColorAsState
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.green.thumb.R
import org.green.thumb.data.Plant
import org.green.thumb.data.SampleData
import org.green.thumb.ui.theme.Part02Theme


@Composable
fun PlantCard(plant: Plant, modifier: Modifier = Modifier) = Column(modifier) {
    Spacer(modifier = Modifier.height(40.dp))
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.ic_plant_default),
            //contentDescription is a mandatory parameter, cannot be omitted.
            contentDescription = "",
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary, BlendMode.SrcIn),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = plant.name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = plant.location,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Start))
        }
    }

    var isExpanded by remember { mutableStateOf(false) }
    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
    )

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = surfaceColor,
        modifier = Modifier
            .animateContentSize()
            .padding(1.dp)
    ) {
        val icon = if (isExpanded) {
            Icons.Filled.KeyboardArrowUp
        } else {
            Icons.Filled.KeyboardArrowDown
        }
        Column {
            Row(modifier = Modifier.clickable(onClick = { isExpanded = !isExpanded })) {
                Text(
                    text = "Plant care log",
                    modifier = Modifier
                        .padding(all = 4.dp)
                        .weight(1f),
                    style = MaterialTheme.typography.titleLarge
                )
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                )
            }

            if (isExpanded) {
                for (care in plant.careLog) {
                    Text(
                        text = "${care.date}: ${care.description}",
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Part02Theme {
        PlantCard(SampleData.plantInventory[0])
    }
}