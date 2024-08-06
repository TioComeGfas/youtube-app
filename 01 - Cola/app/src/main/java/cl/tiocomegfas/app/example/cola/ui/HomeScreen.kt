package cl.tiocomegfas.app.example.cola.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.tiocomegfas.app.example.cola.presentation.HomeContract
import cl.tiocomegfas.app.example.cola.presentation.HomeViewModel
import cl.tiocomegfas.core.architecture.use

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    viewModel: HomeViewModel
) {
    val (state, event, effect) = use(viewModel = viewModel)
    var newItem: String by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(0.5f),
                content = {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp),
                        value = newItem,
                        maxLines = 1,
                        onValueChange = {
                            if(it.length <= 10) newItem = it
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp),
                        onClick = {
                            if(newItem.isEmpty() || newItem.isBlank()) return@Button
                            event.invoke(HomeContract.Event.OnAddItem(newItem))
                            newItem = ""
                        }
                    ) {
                        Text(text = "Insertar item")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            )
            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier,
                content = {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp),
                        value = state.top,
                        maxLines = 1,
                        readOnly = true,
                        onValueChange = {},
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp),
                        onClick = {
                            event.invoke(HomeContract.Event.OnDeleteItem)
                        }
                    ) {
                        Text(text = "Eliminar item")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = 5.dp)
        ) {
            items(
                count = state.items.size,
                itemContent = { index ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp)
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = state.items[index],
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                }
            )
        }
    }
}