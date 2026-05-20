package com.santimattius.cmp.playground

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun CounterDemo() {
    var count by remember { mutableStateOf(0) }

    Column(Modifier.padding(16.dp)) {
        Text("Clicks: $count", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(12.dp))
        Button(onClick = { count++ }) {
            Text("Increment")
        }
    }
}