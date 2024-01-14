package com.example.grocerycenter.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.grocerycenter.data.productList
import com.example.grocerycenter.ui.reusablecomposables.LongProductDisplayer
import com.example.grocerycenter.ui.reusablecomposables.ProductDisplayer
import com.example.grocerycenter.ui.reusablecomposables.Title
import com.example.grocerycenter.ui.state.AppViewModel
import com.example.grocerycenter.ui.theme.Padding

@Composable
fun CompareScreen(
  viewModel: AppViewModel,
  navigateToProduct: () -> Unit,
  modifier: Modifier = Modifier
) {
  if (viewModel.compareList.size == 0) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
      modifier = modifier
        .fillMaxSize()
    ) {
      Text(
        text = "There are no items to compare.",
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.outline,
        modifier = modifier
      )
      Text(
        text = "You can look for the ones you like",
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.outline,
        modifier = modifier
      )
      Text(
        text = "and add them to the list.",
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.outline,
        modifier = modifier
      )
    }
  } else {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = modifier
        .fillMaxWidth()
    ) {
      Title(title = "Comparing List")
      Text(
        text = "From the cheapest to the most expensive",
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.outline,
        modifier = modifier
      )
      Spacer(
        modifier = modifier
          .height(Padding.medium)
      )
      LazyColumn(
        modifier = modifier
          .fillMaxWidth()
      ) {
        items(viewModel.compareList) {
          LongProductDisplayer(
            product = it,
            viewModel = viewModel,
            navigateToProduct = navigateToProduct,
            modifier = modifier
          )
        }
      }
    }
  }
}