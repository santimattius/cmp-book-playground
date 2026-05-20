package com.santimattius.cmp.playground

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class CatalogItem(
	val id: String,
	val title: String,
	val subtitle: String,
)

@Composable
fun CatalogScreen(
	items: List<CatalogItem>,
	onItemClick: (CatalogItem) -> Unit,
	onAddClick: () -> Unit,
	modifier: Modifier = Modifier,
) {
	Box(modifier = modifier.fillMaxSize()) {
		Column(Modifier.fillMaxSize()) {
			TopBar(
				title = "Catalog",
				onSearchClick = { /* TODO */ },
				onSettingsClick = { /* TODO */ },
			)

			FilterRow(
				selected = "All",
				onSelectedChange = { /* TODO */ },
				modifier = Modifier
					.fillMaxWidth()
					.padding(horizontal = 16.dp, vertical = 12.dp),
			)

			HorizontalDivider()

			LazyColumn(
				modifier = Modifier.fillMaxSize(),
				contentPadding = PaddingValues(bottom = 88.dp),
			) {
				items(items, key = { it.id }) { item ->
					CatalogRow(
						item = item,
						onClick = { onItemClick(item) },
						modifier = Modifier.fillMaxWidth(),
					)
					HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
				}
			}
		}

		FloatingActionButton(
			onClick = onAddClick,
			modifier = Modifier
				.align(Alignment.BottomEnd)
				.padding(16.dp),
		) {
			Text("+")
		}
	}
}

@Composable
private fun TopBar(
	title: String,
	onSearchClick: () -> Unit,
	onSettingsClick: () -> Unit,
	modifier: Modifier = Modifier,
) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.padding(horizontal = 16.dp, vertical = 12.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.spacedBy(12.dp),
	) {
		Text(
			text = title,
			style = MaterialTheme.typography.titleLarge,
			modifier = Modifier.weight(1f),
			maxLines = 1,
			overflow = TextOverflow.Ellipsis,
		)
		Text(
			text = "Search",
			color = MaterialTheme.colorScheme.primary,
			modifier = Modifier.clickable(onClick = onSearchClick),
		)
		Text(
			text = "Settings",
			color = MaterialTheme.colorScheme.primary,
			modifier = Modifier.clickable(onClick = onSettingsClick),
		)
	}
}

@Composable
private fun FilterRow(
	selected: String,
	onSelectedChange: (String) -> Unit,
	modifier: Modifier = Modifier,
) {
	Row(
		modifier = modifier,
		horizontalArrangement = Arrangement.spacedBy(8.dp),
		verticalAlignment = Alignment.CenterVertically,
	) {
		AssistChip(onClick = { onSelectedChange("All") }, label = { Text("All") })
		AssistChip(onClick = { onSelectedChange("Favorites") }, label = { Text("Favorites") })
		AssistChip(onClick = { onSelectedChange("Recent") }, label = { Text("Recent") })
	}
}

@Composable
fun CatalogRow(
	item: CatalogItem,
	onClick: () -> Unit,
	modifier: Modifier = Modifier,
) {
	Row(
		modifier = modifier
			.clickable(onClick = onClick)
			.padding(horizontal = 16.dp, vertical = 12.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.spacedBy(12.dp),
	) {
		Box(
			modifier = Modifier
				.size(40.dp)
				.background(Color(0xFFE3F2FD)),
			contentAlignment = Alignment.Center,
		) {
			Text(item.title.take(1))
		}
		Column(Modifier.weight(1f)) {
			Text(item.title, style = MaterialTheme.typography.titleMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
			Text(item.subtitle, style = MaterialTheme.typography.bodyMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
		}
		Icon(
			imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
			contentDescription = null,
			tint = MaterialTheme.colorScheme.outline,
		)
	}
}

@Preview
@Composable
fun CatalogScreenPreview() {
	val items = listOf(
		CatalogItem("1", "Item 1", "Subtitle 1"),
		CatalogItem("2", "Item 2", "Subtitle 2"),
		CatalogItem("3", "Item 3", "Subtitle 3"),
	)
	MaterialTheme {
		Surface {
			CatalogScreen(
				items = items,
				onItemClick = {},
				onAddClick = {},
			)
		}
	}
}
