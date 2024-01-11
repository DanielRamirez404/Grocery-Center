package com.example.grocerycenter.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grocerycenter.data.Product
import com.example.grocerycenter.ui.state.AppViewModel

@Composable
fun ProductScreen(
  viewModel: AppViewModel,
) {
  val uiState = viewModel.uiState.collectAsState()
  val product: Product = uiState.value.selectedProduct
  Text(text = product.name)
}