package com.santimattius.cmp.playground

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
private fun CatalogCanonicalTwoPane(
	items: List<CatalogItem>,
	modifier: Modifier = Modifier,
) {
	val navigator = rememberListDetailPaneScaffoldNavigator<String>()
	var selected by remember { mutableStateOf(items.firstOrNull()) }

	ListDetailPaneScaffold(
		directive = navigator.scaffoldDirective,
		value = navigator.scaffoldValue,
		listPane = {
			AnimatedPane {
				val coroutineScope = rememberCoroutineScope()
				LazyColumn(
					modifier = Modifier.fillMaxSize(),
					contentPadding = PaddingValues(bottom = 88.dp),
				) {
					items(items, key = { it.id }) { item ->
						CatalogRow(
							item = item,
							onClick = {
								selected = item
								coroutineScope.launch {
									navigator.navigateTo(ListDetailPaneScaffoldRole.Detail)
								}
							},
							modifier = Modifier.fillMaxWidth(),
						)
						HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
					}
				}
			}
		},
		detailPane = {
			AnimatedPane {
				//CatalogDetail(item = selected)
			}
		},
		modifier = modifier,
	)
}