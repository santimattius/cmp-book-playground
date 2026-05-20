package com.santimattius.cmp.playground

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CatalogTwoPane(items: List<CatalogItem>, modifier: Modifier = Modifier) {
	var selected by remember { mutableStateOf(items.firstOrNull()) }

	Row(modifier.fillMaxSize()) {
		Surface(
			tonalElevation = 1.dp,
			modifier = Modifier.widthIn(max = 360.dp).fillMaxHeight(),
		) {
			LazyColumn {
				items(items, key = { it.id }) { item ->
					CatalogRow(
						item = item,
						onClick = { selected = item },
						modifier = Modifier.fillMaxWidth(),
					)
					HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
				}
			}
		}

		VerticalDivider()

		Box(Modifier.weight(1f).fillMaxHeight().padding(16.dp)) {
			val current = selected
			if (current == null) {
				Text("Selecciona un elemento", style = MaterialTheme.typography.titleMedium)
			} else {
				Text(current.title, style = MaterialTheme.typography.titleLarge)
				// TODO: detalle completo
			}
		}
	}
}