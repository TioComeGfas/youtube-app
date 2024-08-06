@file:Suppress("UNUSED_EXPRESSION")
@file:OptIn(ExperimentalMaterial3Api::class)

package cl.tiocomegfas.app.example.cola

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.tiocomegfas.app.example.cola.di.ViewModelFactory
import cl.tiocomegfas.app.example.cola.ui.HomeScreen
import cl.tiocomegfas.app.example.cola.ui.theme.MyTheme

class MainActivity : ComponentActivity() {

    companion object {
        private const val ROUTE = "home"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "Queue Data structure",
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        )
                    }
                ) { innerPadding ->
                    val controller = rememberNavController()
                    NavHost(
                        navController = controller,
                        startDestination = ROUTE
                    ) {
                        composable(
                            route = ROUTE
                        ) { navBackStackEntry ->
                            CompositionLocalProvider(
                                LocalLifecycleOwner provides navBackStackEntry
                            ) {
                                HomeScreen(
                                    paddingValues = innerPadding,
                                    viewModel = viewModel(
                                        factory = ViewModelFactory.createHome()
                                    )
                                )
                            }
                        }
                    }
                    innerPadding
                }
            }
        }
    }
}
