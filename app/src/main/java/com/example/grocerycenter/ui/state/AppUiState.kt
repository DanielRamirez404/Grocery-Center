package com.example.grocerycenter.ui.state

import com.example.grocerycenter.data.Product
import com.example.grocerycenter.data.productList

data class AppUiState(
  val compareList: MutableList<Product> = mutableListOf(productList[0]),
  val selectedProduct: Product = productList[0]
)
