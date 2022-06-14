package org.green.thumb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import org.green.thumb.data.Plant
import org.green.thumb.data.SampleData
import org.green.thumb.ui.theme.Part01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Part01Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    PlantOverview(SampleData.plantInventory)
                }
            }
        }
    }
}

@Composable
fun PlantOverviewScreen(plants: LiveData<List<Plant>>){
    val plantsInventory by plants.observeAsState()
    PlantOverview(inventory = plantsInventory)
}

@Composable
fun PlantOverview(inventory: List<Plant>) =
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(inventory) { plant ->
            PlantCard(plant)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

@Composable
fun PlantCard(plant: Plant, modifier: Modifier = Modifier) = Column(modifier) {
    Spacer(modifier = Modifier.height(40.dp))
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.ic_plant_default),
            //contentDescription is a mandatory parameter, cannot be omitted.
            contentDescription = "",
            colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary, BlendMode.SrcIn),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = plant.name,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = plant.location,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.secondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Start))
        }
    }

    var isExpanded by remember { mutableStateOf(false) }
    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
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
                    style = MaterialTheme.typography.h5
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
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Part01Theme {
        PlantCard(SampleData.plantInventory[0])
    }
}