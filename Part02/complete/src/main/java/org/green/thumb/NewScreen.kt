package org.green.thumb

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewScreen(title: String, modifier: Modifier = Modifier) = Column(modifier
    .fillMaxWidth()
    .padding(8.dp)) {
    Text(text = title,
        style = MaterialTheme.typography.titleLarge)
}