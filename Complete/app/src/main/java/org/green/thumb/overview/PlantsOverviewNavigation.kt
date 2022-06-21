package org.green.thumb.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

enum class PlantOviewviewDestinations(val title: String, val icon: ImageVector) {
    INVENTORY("Inventory", Icons.Default.List),
    ARTICLES("Articles", Icons.Default.Favorite),
    NOTIFICATIONS("Notifications", Icons.Default.Notifications),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantOverviewNavDrawerContent(
    selectedDestination: PlantOviewviewDestinations,
    modifier: Modifier = Modifier,
    onDrawerClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .systemBarsPadding()
            .wrapContentWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(24.dp)
    ) {
        PlantOviewviewDestinations.values().forEach {
            NavigationDrawerItem(
                selected = selectedDestination == it,
                label = { Text(text = it.title, modifier = Modifier.padding(horizontal = 16.dp)) },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent),
                onClick = {
                    // TODO
                    onDrawerClicked.invoke()
                }
            )
        }
    }
}

@Composable
fun PlantOverviewNavRailContent(
    selectedDestination: PlantOviewviewDestinations,
    onDrawerClicked: () -> Unit
) {
    NavigationRail(modifier = Modifier.fillMaxHeight()) {
        NavigationRailItem(
            selected = false,
            onClick = onDrawerClicked,
            modifier = Modifier.padding(bottom = 16.dp),
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Open menu"
                )
            }
        )
        PlantOviewviewDestinations.values().forEach {
            NavigationRailItem(
                selected = selectedDestination == it,
                onClick = {
                    // TODO
                },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                }
            )
        }
    }
}

@Composable
fun PlantOverviewNavBarContent(
    selectedDestination: PlantOviewviewDestinations
) {
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        PlantOviewviewDestinations.values().forEach {
            NavigationBarItem(
                selected = selectedDestination == it,
                onClick = {
                    // TODO
                },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                }
            )
        }
    }
}
