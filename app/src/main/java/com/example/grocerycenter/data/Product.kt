package com.example.grocerycenter.data
data class Product(
  val name: String,
  val image: Int,
  val brand: String,
  val supermarket: Supermarket,
  val price: Float,
  val extraInfo: String,
  val hasOffer: Boolean = false,
  val discountedPrice: Float = 0.0f,
)
