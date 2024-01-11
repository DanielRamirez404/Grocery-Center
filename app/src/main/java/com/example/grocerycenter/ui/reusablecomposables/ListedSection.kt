package com.example.grocerycenter.ui.reusablecomposables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.grocerycenter.data.Product
import com.example.grocerycenter.ui.state.AppViewModel
import com.example.grocerycenter.ui.theme.Padding

@Composable
fun ListedSection(
  viewModel: AppViewModel,
  navigateToProduct: () -> Unit,
  title: String,
  list: List<Product>,
  modifier: Modifier = Modifier
) {
  val myPadding = Padding.large
  Column(modifier = modifier) {
    Title(
      title = title,
      modifier = modifier
        .padding(myPadding, Padding.none, Padding.none, Padding.medium)
    )
    LazyRow(
      horizontalArrangement = Arrangement.spacedBy(myPadding),
      contentPadding = PaddingValues(myPadding, Padding.none),
      modifier = modifier
        .fillMaxWidth()
    ) {
      items(list) {product ->
        ProductDisplayer(
          product = product,
          navigateToProduct = navigateToProduct,
          viewModel = viewModel
        )
      }
    }
  }
}