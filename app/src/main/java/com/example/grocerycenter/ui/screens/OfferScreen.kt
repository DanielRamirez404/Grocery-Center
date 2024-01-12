package com.example.grocerycenter.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Special Offers",
      list = getRandomOffers(),
      modifier = modifier
    )
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Offers in Más Por Menos",
      list = getRandomOffersFrom(Supermarket.MasPorMenos),
      modifier = modifier
    )
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Offers in Aikoz",
      list = getRandomOffersFrom(Supermarket.Aikoz),
      modifier = modifier
    )
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Offers in Rio",
      list = getRandomOffersFrom(Supermarket.Rio),
      modifier = modifier
    )
  }
}