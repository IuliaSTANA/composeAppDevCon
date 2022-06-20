package org.green.thumb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import org.green.thumb.overview.PlantOverviewViewModel
import org.green.thumb.ui.theme.Part02Theme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<PlantOverviewViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Part02Theme {
                NavGraph()
            }
        }
    }
}
