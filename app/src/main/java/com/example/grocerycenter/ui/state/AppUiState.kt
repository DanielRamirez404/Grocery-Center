package com.example.grocerycenter.ui.state

import com.example.grocerycenter.data.Product
import com.example.grocerycenter.data.Supermarket
import com.example.grocerycenter.data.productList
import com.example.grocerycenter.ui.reusablecomposables.getProductListFrom
import com.example.grocerycenter.ui.reusablecomposables.getRandomOffers
import com.example.grocerycenter.ui.reusablecomposables.getRandomOffersFrom
import com.example.grocerycenter.ui.reusablecomposables.getRandomProductList

data class AppUiState(
  val popularProducts: List<Product> = getRandomProductList(),
  val popularMap: Map<Supermarket, List<Product>> = mapOf(
    Supermarket.MasPorMenos to getProductListFrom(Supermarket.MasPorMenos),
    Supermarket.Aikoz to getProductListFrom(Supermarket.Aikoz),
    Supermarket.Rio to getProductListFrom(Supermarket.Rio),
  ),
  val popularOffers: List<Product> = getRandomOffers(),
  val offersMap: Map<Supermarket, List<Product>> = mapOf(
    Supermarket.MasPorMenos to getRandomOffersFrom(Supermarket.MasPorMenos),
    Supermarket.Aikoz to getRandomOffersFrom(Supermarket.Aikoz),
    Supermarket.Rio to getRandomOffersFrom(Supermarket.Rio),
  ),
  val selectedProduct: Product = productList[0]
)
