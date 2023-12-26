package com.example.grocerycenter.data
data class Product(
  val name: String,
  val image: Int,
  val brand: String,
  val supermarket: Supermarket,
  val price: Float,
  val extraInfo: String? = null,
  val hasOffer: Boolean = false,
  val discount: Int = 0,
)
