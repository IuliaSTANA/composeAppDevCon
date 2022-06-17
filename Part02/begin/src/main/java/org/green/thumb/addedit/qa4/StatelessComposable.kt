package org.green.thumb.addedit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.green.thumb.R
import org.green.thumb.data.Plant


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditPlantScreen(
    viewModel: AddEditPlantViewModel,
    modifier: Modifier = Modifier,
) = Scaffold(
    modifier = modifier,
) { paddingValues ->

    val defaultChoice = stringResource(id = R.string.select)
    val currentPlant by viewModel.currentPlant.observeAsState(Plant())
    val isNameInvalid = rememberSaveable { mutableStateOf(false) }
    val currentWateringChoice = rememberSaveable { mutableStateOf(defaultChoice) }

    AddEditPlantContentStateless(
        name = currentPlant.name,
        location = currentPlant.location,
        isError = isNameInvalid.value,
        onNameChange = { viewModel.setPlantName(it) },
        validateName = { isNameInvalid.value = viewModel.isNameInvalid() },
        onLocationChange = { viewModel.setPlantLocation(it) },
        onWateringFrequencySelect = { index, label ->
            viewModel.setPlantWateringFrequency(index)
            currentWateringChoice.value = label
        },
        currentChoice = currentWateringChoice.value,
        onClick = { viewModel.savePlant() },
        modifier = Modifier.padding(paddingValues)
    )
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddEditPlantContentStateless(
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
) = Column(Modifier
    .fillMaxSize()
    .padding(16.dp)
) {
}

