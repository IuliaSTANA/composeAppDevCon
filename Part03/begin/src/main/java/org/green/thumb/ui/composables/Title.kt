package org.green.thumb.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.green.thumb.ui.theme.SpacingXLarge_LogoToTitle

@Composable
fun Title(title: String, modifier: Modifier = Modifier) = Column(modifier = modifier) {
    Spacer(Modifier.height(SpacingXLarge_LogoToTitle))
    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge,
    )
}