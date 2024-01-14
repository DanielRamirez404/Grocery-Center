package com.example.grocerycenter.data

import com.example.grocerycenter.R

enum class Supermarket {
  MasPorMenos,
  Aikoz,
  Rio
}

fun MarketToDrawable(supermarket: Supermarket) : Int {
  return when (supermarket) {
    Supermarket.MasPorMenos -> R.drawable.mas_por_menos_logo
    Supermarket.Aikoz -> R.drawable.aikoz_logo
    else -> R.drawable.rio_supermarket_logo
  }
}

fun MarketToString(supermarket: Supermarket) : String {
 return when(supermarket) {
   Supermarket.MasPorMenos -> "Más Por Menos"
   Supermarket.Aikoz -> "Aikoz"
   else -> "Río"
 }
}