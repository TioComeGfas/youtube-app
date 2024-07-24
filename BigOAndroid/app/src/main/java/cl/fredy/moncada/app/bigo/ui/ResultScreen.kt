package cl.fredy.moncada.app.bigo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.fredy.moncada.app.bigo.presentation.ResultViewModel

@Composable
fun ResultScreen(
    paddingValues: PaddingValues,
    viewModel: ResultViewModel
) {
    // val (state, event, effect) = use(viewModel)
    LaunchedEffect(Unit) {

    }

}

@Composable
private fun InitialState(
    onExecute: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        // Here insert code for details
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun ErrorState(
    onAccept: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}