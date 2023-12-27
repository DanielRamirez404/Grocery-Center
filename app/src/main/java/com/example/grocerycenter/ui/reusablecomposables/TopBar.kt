package com.example.grocerycenter.ui.reusablecomposables

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(name: String, modifier: Modifier = Modifier) {
  TopAppBar(
    modifier = modifier,
    title = { 
      Text(text = name)
    }
  )
}