package com.example.grocerycenter.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.grocerycenter.data.productList
import com.example.grocerycenter.ui.reusablecomposables.LongProductDisplayer
import com.example.grocerycenter.ui.reusablecomposables.ProductDisplayer
import com.example.grocerycenter.ui.state.AppViewModel

@Composable
fun CompareScreen(
  viewModel: AppViewModel,
  navigateToProduct: () -> Unit,
  modifier: Modifier = Modifier
) {
  val uiState by viewModel.uiState.collectAsState()
  if (uiState.compareList.size == 0) {
    Text(text = "No items yet to compare")
  }
  LazyColumn(
    modifier = modifier
  ) {
    items(uiState.compareList) {
      LongProductDisplayer(
        product = it,
        viewModel = viewModel,
        navigateToProduct = navigateToProduct,
        modifier = modifier
      )
    }
  }
}