package com.kamalbramwell.motivation.preview

import MotivationScreen
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
private fun MotivationScreenPreview() {
    MaterialTheme {
        MotivationScreen()
    }
}