package org.green.thumb.addedit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun DropDownField(
    label: String,
    choices: List<String>,
    currentChoice: String,
    onSelectChoice: (Int, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        var isMenuExpanded by remember { mutableStateOf(false) }

        val icon = if (isMenuExpanded) {
            Icons.Filled.KeyboardArrowUp
        } else {
            Icons.Filled.KeyboardArrowDown
        }
        Text(text = label,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth())

        Box(modifier = modifier.fillMaxWidth()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { isMenuExpanded = !isMenuExpanded }) {
                Text(text = currentChoice,
                    modifier = Modifier.weight(1f))
                Icon(imageVector = icon, contentDescription = "")
            }
            DropdownMenu(
                expanded = isMenuExpanded,
                onDismissRequest = { isMenuExpanded = false },
                modifier = Modifier
                    .wrapContentSize()
            ) {
                choices.forEachIndexed { index, choice ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = choice,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier
                                    .fillMaxWidth(),
                            )
                        },
                        onClick = {
                            onSelectChoice(index, choice)
                            isMenuExpanded = false
                        },
                    )
                }
            }
        }
    }

}

