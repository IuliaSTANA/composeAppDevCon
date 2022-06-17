package org.green.thumb.addedit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.green.thumb.R


@Composable
fun AddEditPlantContent(
    modifier: Modifier = Modifier,
) = Column(Modifier
    .fillMaxSize()
    .padding(16.dp)
) {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        isError = false,
        singleLine = true,
        label = {
            Text(
                text = stringResource(R.string.addedit_plant_name),
            )
        }
    )
}