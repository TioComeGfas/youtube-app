@file:OptIn(ExperimentalMaterial3Api::class)

package cl.fredy.moncada.app.bigo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import cl.fredy.moncada.app.bigo.di.ViewModelFactory
import cl.fredy.moncada.app.bigo.ui.ResultScreen
import cl.fredy.moncada.app.bigo.ui.theme.BigOAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BigOAndroidTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Big O") }
                        )
                    },
                    content = { innerPadding ->
                        ResultScreen(
                            paddingValues = innerPadding,
                            viewModel = ViewModelFactory.createResult()
                        )
                        innerPadding
                    }
                )
            }
        }
    }
}
