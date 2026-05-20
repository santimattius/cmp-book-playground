package com.santimattius.cmp.playground

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

private val sampleItems = List(20) {
	CatalogItem(
		id = it.toString(),
		title = "Item #$it",
		subtitle = "Example subtitle to validate overflow",
	)
}

@Preview(name = "Phone")
@Composable
private fun CatalogPhonePreview() {
	MaterialTheme {
		CatalogScreen(
			items = sampleItems,
			onItemClick = {},
			onAddClick = {},
		)
	}
}

@Preview(name = "Tablet", widthDp = 1000, heightDp = 700)
@Composable
private fun CatalogTabletPreview() {
	MaterialTheme {
		CatalogAdaptiveScreen(
			window = WindowClass(WidthClass.Expanded),
			items = sampleItems,
		)
	}
}