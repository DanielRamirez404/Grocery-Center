package com.example.grocerycenter.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.grocerycenter.data.Supermarket
import com.example.grocerycenter.ui.reusablecomposables.ListedSection
import com.example.grocerycenter.ui.reusablecomposables.getRandomOffers
import com.example.grocerycenter.ui.reusablecomposables.getRandomOffersFrom
import com.example.grocerycenter.ui.state.AppViewModel

@Composable
fun OffersScreen(
  viewModel: AppViewModel,
  navigateToProduct: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .verticalScroll(rememberScrollState())
  ) {
    val uiState by viewModel.uiState.collectAsState()
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Special Offers",
      list = uiState.popularOffers,
      modifier = modifier
    )
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Offers in Más Por Menos",
      list = uiState.offersMap.getValue(Supermarket.MasPorMenos),
      modifier = modifier
    )
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Offers in Aikoz",
      list = uiState.offersMap.getValue(Supermarket.Aikoz),
      modifier = modifier
    )
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Offers in Rio",
      list = uiState.offersMap.getValue(Supermarket.Rio),
      modifier = modifier
    )
  }
}