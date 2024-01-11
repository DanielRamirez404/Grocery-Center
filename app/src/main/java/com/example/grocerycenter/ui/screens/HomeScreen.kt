package com.example.grocerycenter.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grocerycenter.data.Product
import com.example.grocerycenter.data.productList
import com.example.grocerycenter.ui.reusablecomposables.ListedSection
import com.example.grocerycenter.ui.reusablecomposables.ProductDisplayer
import com.example.grocerycenter.ui.reusablecomposables.Title
import com.example.grocerycenter.ui.state.AppViewModel
import com.example.grocerycenter.ui.theme.Padding

@Composable
fun HomeScreen(
  viewModel: AppViewModel,
  navigateToProduct: () -> Unit,
  modifier: Modifier = Modifier
) {
  ListedSection(
    viewModel = viewModel,
    navigateToProduct = navigateToProduct,
    title = "Popular Products",
    list = listOf<Product>(
      productList[0],
      productList[1],
      productList[2]
    ),
    modifier = modifier
  )
}