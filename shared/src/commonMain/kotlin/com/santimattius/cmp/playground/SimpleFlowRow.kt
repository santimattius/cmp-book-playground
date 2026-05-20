package com.santimattius.cmp.playground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

@Composable
fun SimpleFlowRow(
	modifier: Modifier = Modifier,
	horizontalGapPx: Int = 16,
	verticalGapPx: Int = 12,
	content: @Composable () -> Unit,
) {
	Layout(
		content = content,
		modifier = modifier,
	) { measurables, constraints ->
		val maxWidth = constraints.maxWidth
		val placeables = measurables.map { measurable ->
			measurable.measure(
				Constraints(
					minWidth = 0,
					maxWidth = maxWidth,
					minHeight = 0,
					maxHeight = constraints.maxHeight,
				)
			)
		}

		val positions = ArrayList<Pair<Int, Int>>(placeables.size)
		var x = 0
		var y = 0
		var rowHeight = 0

		placeables.forEach { p ->
			val needsGap = x > 0
			val proposedX = if (needsGap) x + horizontalGapPx else x
			val fitsInRow = proposedX + p.width <= maxWidth

			if (fitsInRow) {
				positions += proposedX to y
				x = proposedX + p.width
				rowHeight = maxOf(rowHeight, p.height)
			} else {
				y += rowHeight + verticalGapPx
				positions += 0 to y
				x = p.width
				rowHeight = p.height
			}
		}

		val totalHeight = (y + rowHeight).coerceIn(constraints.minHeight, constraints.maxHeight)
		layout(width = maxWidth, height = totalHeight) {
			placeables.forEachIndexed { index, p ->
				val (px, py) = positions[index]
				p.place(px, py)
			}
		}
	}
}

@Composable
@Preview
fun SimpleFlowRowPreview() {
    MaterialTheme {
        SimpleFlowRow(
            modifier = Modifier.padding(16.dp),
            horizontalGapPx = 16,
            verticalGapPx = 16
        ) {
            val tags = listOf(
                "Compose", "Kotlin", "Multiplatform", "Android", "iOS",
                "Desktop", "Web", "FlowRow", "Custom Layout", "UI"
            )
            tags.forEach { tag ->
                Box(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Text(text = tag, color = MaterialTheme.colorScheme.onPrimaryContainer)
                }
            }
        }
    }
}
