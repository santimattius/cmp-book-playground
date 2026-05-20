package com.santimattius.cmp.playground

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

enum class WidthClass { Compact, Medium, Expanded }

data class WindowClass(val width: WidthClass)

@Composable
fun CatalogAdaptiveScreen(
    window: WindowClass,
    items: List<CatalogItem>,
    modifier: Modifier = Modifier,
) {
    when (window.width) {
        WidthClass.Compact -> CatalogOnePane(items, modifier)
        WidthClass.Medium, WidthClass.Expanded -> CatalogTwoPane(items, modifier)
    }
}

@Composable
private fun CatalogOnePane(items: List<CatalogItem>, modifier: Modifier = Modifier) {
    CatalogScreen(
        items = items,
        onItemClick = { /* navegar a detalle */ },
        onAddClick = { /* TODO */ },
        modifier = modifier,
    )
}

@Preview(name = "Phone")
@Composable
fun CatalogAdaptiveScreenCompactPreview() {
    val items = listOf(
        CatalogItem("1", "Item 1", "Subtitle 1"),
        CatalogItem("2", "Item 2", "Subtitle 2"),
        CatalogItem("3", "Item 3", "Subtitle 3"),
    )
    MaterialTheme {
        Surface {
            CatalogAdaptiveScreen(
                window = WindowClass(WidthClass.Compact),
                items = items,
            )
        }
    }
}

@Preview(name = "Tablet", widthDp = 1000, heightDp = 700)
@Composable
fun CatalogAdaptiveScreenExpandedPreview() {
    val items = listOf(
        CatalogItem("1", "Item 1", "Subtitle 1"),
        CatalogItem("2", "Item 2", "Subtitle 2"),
        CatalogItem("3", "Item 3", "Subtitle 3"),
    )
    MaterialTheme {
        Surface {
            CatalogAdaptiveScreen(
                window = WindowClass(WidthClass.Expanded),
                items = items,
            )
        }
    }
}
