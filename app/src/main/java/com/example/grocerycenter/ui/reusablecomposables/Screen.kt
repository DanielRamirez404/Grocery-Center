package com.example.grocerycenter.ui.reusablecomposables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.grocerycenter.ui.theme.Padding
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
  topBar: @Composable () -> Unit,
  content: @Composable () -> Unit,
  bottomBar: @Composable () -> Unit,
  modifier: Modifier = Modifier,
) {
  Scaffold(
    topBar = { topBar() },
    bottomBar = { bottomBar() }
  ) {
    Column(modifier = modifier.padding(it)) {
      content()
    }
  }
}