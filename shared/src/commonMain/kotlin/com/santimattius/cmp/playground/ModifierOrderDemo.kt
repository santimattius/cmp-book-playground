package com.santimattius.cmp.playground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun ModifierOrderDemo() {
	Column {
		Text(
			text = "Padding then background",
			modifier = Modifier
				.padding(12.dp)
				.background(Color(0xFFFFF59D)),
		)

		Text(
			text = "Background then padding",
			modifier = Modifier
				.background(Color(0xFFFFF59D))
				.padding(12.dp),
		)
	}
}