package com.santimattius.cmp.playground

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UserProfileCard(
    name: String,
    handle: String,
    bio: String,
    onFollowClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier) {
        Column(Modifier.padding(16.dp)) {
            Text(name, style = MaterialTheme.typography.titleMedium)
            Text(handle, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.height(8.dp))
            Text(bio, style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(12.dp))
            Button(onClick = onFollowClick) {
                Text("Follow")
            }
        }
    }
}

@Composable
@Preview
fun UserProfileScreen() {
    UserProfileCard(
        name = "Ada Lovelace",
        handle = "@ada",
        bio = "I write about architecture and declarative programming.",
        onFollowClick = { /* TODO */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}