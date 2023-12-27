package com.example.grocerycenter.ui.reusablecomposables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(modifier: Modifier = Modifier) {
  BottomAppBar(
    modifier = modifier
      .fillMaxWidth()
  ) {
    Text(text = "Example Bar")
  }
}