package org.green.thumb.addedit

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import org.green.thumb.R

@Composable
fun AddEditPlantContentStateful(
    modifier: Modifier = Modifier,
) = Column(Modifier
    .fillMaxSize()
    .padding(16.dp)
) {
    Spacer(Modifier.height(56.dp))
    val focusManager = LocalFocusManager.current
    val nameInputText = rememberSaveable { mutableStateOf("") }
    val isNameInvalid = rememberSaveable { mutableStateOf(false) }
    val locationInputText = rememberSaveable { mutableStateOf("") }
    val currentChoice = rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = nameInputText.value,
        onValueChange = { nameInputText.value = it },
        isError = isNameInvalid.value,
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
                isNameInvalid.value = nameInputText.value.isEmpty()
            },
        ),
        label = {
            Text(
                text = stringResource(R.string.addedit_plant_name),
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
    OutlinedTextField(
        value = locationInputText.value,
        onValueChange = { locationInputText.value = it },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            },
        ),

        label = {
            Text(
                text = stringResource(R.string.addedit_plant_location),
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
    DropDownField(
        label = stringResource(id = R.string.addedit_plant_watering),
        choices = stringArrayResource(id = R.array.watering_frequency).toList(),
        currentChoice = currentChoice.value,
        onSelectChoice = { _, label ->
            currentChoice.value = label
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp, 56.dp)
    )
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .sizeIn(minHeight = 48.dp),
        enabled = isNameInvalid.value.not()
    ) {
        Text(
            text = stringResource(R.string.addedit_plant_save),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Icon(
            Icons.Outlined.Check,
            contentDescription = "",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
    }
}

