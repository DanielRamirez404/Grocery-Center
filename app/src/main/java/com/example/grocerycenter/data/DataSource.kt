package com.example.grocerycenter.data

import com.example.grocerycenter.R

val productList = listOf(
  Product(
    name = "Harina de Maíz",
    image = R.drawable.harina_pan,
    brand = "PAN",
    supermarket = Supermarket.Aikoz,
    extraInfo = "1kg",
    price = 3.33f
  ),
  Product(
    name = "Salsa de Tomate",
    image = R.drawable.salsa_de_tomate_heinz,
    brand = "Heinz",
    supermarket = Supermarket.MasPorMenos,
    extraInfo = "14oz",
    price = 2.98f
  ),
  Product(
    name = "Pasta Corta",
    image = R.drawable.pasta_corta_primor,
    brand = "Primor",
    supermarket = Supermarket.Rio,
    extraInfo = "1kg",
    price = 2.6f
  )
)