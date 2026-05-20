package com.santimattius.cmp.playground

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TagsSection(tags: List<String>) {
	SimpleFlowRow(modifier = Modifier.padding(16.dp)) {
		tags.forEach { tag ->
			AssistChip(
				onClick = { /* TODO */ },
				label = { Text(tag) },
			)
		}
	}
}

@Composable
@Preview
fun TagsSectionPreview() {
	MaterialTheme {
		val tags = listOf(
			"Compose", "Kotlin", "Multiplatform", "Android", "iOS",
			"Desktop", "Web", "FlowRow", "Custom Layout", "UI"
		)
		TagsSection(tags = tags)
	}
}
