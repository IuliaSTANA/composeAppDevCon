package org.green.thumb.plant.addedit

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import org.green.thumb.R
import org.green.thumb.data.Plant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditPlantScreen(
    plantId: String?,
    onPlantUpdate: () -> Unit,
    viewModel: AddEditPlantViewModel,
    state: AddEditPlantState = rememberAddEditPlantState(
        plantId = plantId,
        viewModel = viewModel,
        onPlantSaved = onPlantUpdate,
        defaultChoice = stringResource(id = R.string.select)
    ),
    modifier: Modifier = Modifier,
) = Scaffold(
    modifier = modifier
        .navigationBarsPadding(),
) { paddingValues ->

    val currentPlant by viewModel.currentPlant.observeAsState(Plant())

    AddEditPlantContent(
        name = currentPlant.name,
        location = currentPlant.location,
        isError = state.isNameInvalid,
        onNameChange = state::onNameChange,
        validateName = state::validateName,
        onLocationChange = state::onLocationChange,
        onWateringFrequencySelect = state::onWateringFrequencySelect,
        currentChoice = state.currentWateringChoice,
        onClick = state::onSaveClick,
        modifier = Modifier.padding(paddingValues)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditPlantContent(
    name: String,
    onNameChange: (String) -> Unit,
    validateName: () -> Unit,
    location: String,
    onLocationChange: (String) -> Unit,
    isError: Boolean,
    onWateringFrequencySelect: (Int, String) -> Unit,
    currentChoice: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) =
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        val options = stringArrayResource(id = R.array.watering_frequency).toList()
        var expanded by rememberSaveable { mutableStateOf(false) }

        Column(
            Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            val focusManager = LocalFocusManager.current

            val label = stringResource(R.string.addedit_plant_name)
            Text(
                text = stringResource(id = R.string.addedit_title),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            )

            Spacer(Modifier.height(24.dp))
            OutlinedTextField(
                value = name,
                onValueChange = {
                    onNameChange.invoke(it)
                    validateName()
                },
                isError = isError,
                singleLine = true,
                label = {
                    Text(
                        text = if (isError) "$label*" else label,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                        validateName()
                    },
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = location,
                onValueChange = onLocationChange,
                singleLine = true,
                label = {
                    Text(
                        text = stringResource(id = R.string.addedit_plant_location),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    },
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    readOnly = true,
                    value = currentChoice,
                    onValueChange = {
                        // Can't change; read-only
                    },
                    label = { Text(stringResource(id = R.string.addedit_plant_watering)) },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    options.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                expanded = false
                                selectionOption.let {
                                    onWateringFrequencySelect.invoke(options.indexOf(it), it)
                                }
                            },
                            text = {
                                Text(text = selectionOption)
                            }
                        )
                    }
                }
            }
        }

        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(minHeight = 48.dp),
            enabled = isError.not()
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
        Spacer(Modifier.height(24.dp))
    }
