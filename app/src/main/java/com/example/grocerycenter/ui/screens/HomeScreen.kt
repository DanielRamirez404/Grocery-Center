package com.example.grocerycenter.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grocerycenter.data.Product
import com.example.grocerycenter.data.Supermarket
import com.example.grocerycenter.data.productList
import com.example.grocerycenter.ui.reusablecomposables.ListedSection
import com.example.grocerycenter.ui.reusablecomposables.ProductDisplayer
import com.example.grocerycenter.ui.reusablecomposables.Title
import com.example.grocerycenter.ui.reusablecomposables.getProductListFrom
import com.example.grocerycenter.ui.reusablecomposables.getRandomOffers
import com.example.grocerycenter.ui.reusablecomposables.getRandomProductList
import com.example.grocerycenter.ui.state.AppViewModel
import com.example.grocerycenter.ui.theme.Padding

@Composable
fun HomeScreen(
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
      title = "Popular Products",
      list = getRandomProductList(),
      modifier = modifier
    )
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Popular in Más Por Menos",
      list = getProductListFrom(Supermarket.MasPorMenos),
      modifier = modifier
    )
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Popular in Aikoz",
      list = getProductListFrom(Supermarket.Aikoz),
      modifier = modifier
    )
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Popular in Rio",
      list = getProductListFrom(Supermarket.Rio),
      modifier = modifier
    )
    ListedSection(
      viewModel = viewModel,
      navigateToProduct = navigateToProduct,
      title = "Special Offers",
      list = getRandomOffers(),
      modifier = modifier
    )
  }
}