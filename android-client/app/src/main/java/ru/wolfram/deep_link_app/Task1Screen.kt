package ru.wolfram.deep_link_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task1Screen(
    pDefault: Int?,
    qDefault: Int?,
    nDefault: Long?
) {
    val p = remember { mutableStateOf((pDefault ?: "").toString()) }
    val q = remember { mutableStateOf((qDefault ?: "").toString()) }
    val n = remember { mutableStateOf((nDefault ?: "").toString()) }
    val result = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    val model = Task1Model()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = p.value,
            onValueChange = {
                p.value = it
            },
            label = {
                Text("p")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = q.value,
            onValueChange = {
                q.value = it
            },
            label = {
                Text("q")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = n.value,
            onValueChange = {
                n.value = it
            },
            label = {
                Text("n")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                scope.launch {
                    result.value = model.calculate(
                        p.value.toIntOrNull(),
                        q.value.toIntOrNull(),
                        n.value.toLongOrNull()
                    ).toString()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp),
            shape = RectangleShape
        ) {
            Text(
                text = "Calculate",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = result.value,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}