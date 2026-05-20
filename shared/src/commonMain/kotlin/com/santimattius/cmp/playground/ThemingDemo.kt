package com.santimattius.cmp.playground

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ThemingDemo() {
  MaterialTheme {
    Column {
      Text(
        text = "Title",
        style = MaterialTheme.typography.titleLarge,
      )
      Text(
        text = "Body text with consistent styling.",
        style = MaterialTheme.typography.bodyMedium,
      )
    }
  }
}