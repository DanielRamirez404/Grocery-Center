package com.example.grocerycenter.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.grocerycenter.data.Product
import com.example.grocerycenter.data.productList
import com.example.grocerycenter.ui.reusablecomposables.ProductDisplayer
import com.example.grocerycenter.ui.theme.Padding

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
  val popularProducts = listOf<Product>(
    productList[0],
    productList[1],
    productList[2]
  )
  LazyRow(
    horizontalArrangement = Arrangement.SpaceEvenly,
    modifier = modifier
      .fillMaxWidth()
      .padding(Padding.medium, Padding.none)
  ) {
    items(popularProducts) {product ->
      ProductDisplayer(product)
    }
  }
}