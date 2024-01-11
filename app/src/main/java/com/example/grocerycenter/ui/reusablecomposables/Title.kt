package com.example.grocerycenter.ui.reusablecomposables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun Title(
  title: String,
  modifier: Modifier = Modifier
) {
  Text(
    text = title,
    style = MaterialTheme.typography.titleLarge,
    fontWeight = FontWeight.SemiBold,
    color = Color.DarkGray.copy(alpha = 0.5f),
    modifier = modifier
  )
}