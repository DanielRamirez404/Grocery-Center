package com.example.grocerycenter.ui.reusablecomposables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grocerycenter.R
import com.example.grocerycenter.data.MarketToDrawable
import com.example.grocerycenter.data.MarketToString
import com.example.grocerycenter.data.Product
import com.example.grocerycenter.data.Supermarket
import com.example.grocerycenter.data.productList
import com.example.grocerycenter.ui.state.AppViewModel
import com.example.grocerycenter.ui.theme.Padding

@Composable
fun ProductDisplayer(
  product: Product,
  viewModel: AppViewModel,
  modifier: Modifier = Modifier,
  navigateToProduct: () -> Unit
) {
  val width = 175.dp
  Box(
    Modifier.clickable {
      viewModel.selectProduct(product)
      navigateToProduct()
    }
  ) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
      modifier = modifier
        .width(width)
        .shadow(elevation = 3.dp)
    ) {
      Spacer(
        modifier = modifier
          .height(1.5.dp)
      )
      Image(
        painter = painterResource(id = MarketToDrawable(product.supermarket)),
        contentDescription = null,
        modifier = Modifier
          .fillMaxWidth()
          .height(30.dp)
          .align(Alignment.CenterHorizontally)
          .background(color = MaterialTheme.colorScheme.background)
      )
      Image(
        painter = painterResource(product.image),
        contentDescription = product.name,
        contentScale = ContentScale.FillWidth,
        modifier = modifier
          .height(width)
          .fillMaxWidth()
      )
      Column(
        modifier = modifier
          .fillMaxWidth()
          .background(color = MaterialTheme.colorScheme.background)
          .padding(Padding.small)
      ) {
        Text(
          text = product.name,
          style = MaterialTheme.typography.titleMedium
        )
        Text(
          text = product.brand,
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.outline
        )
        Row(
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically,
          modifier = modifier
            .fillMaxWidth()
        ) {
          Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
            if (product.hasOffer) {
              Text(
                text = "$" + product.discountedPrice.toString() + " ",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.inversePrimary,
                fontWeight = FontWeight.Bold,
              )
            }
            Text(
              text = "$" + product.price.toString(),
              style = if (product.hasOffer) MaterialTheme.typography.bodySmall else MaterialTheme.typography.bodyLarge,
              color = if (product.hasOffer) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.inversePrimary,
              fontWeight = FontWeight.Bold,
              textDecoration = if (product.hasOffer) TextDecoration.LineThrough else TextDecoration.None,
            )
          }
          Button(
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(35),
            contentPadding = PaddingValues(0.dp),
            onClick = {
              if (!viewModel.compareList.contains(product)) {
                viewModel.addProductToCompare(product)
              }
            },
            modifier = modifier
              .padding(Padding.none)
              .height(30.dp)
              .width(50.dp)
          ) {
            Icon(
              painter = painterResource(id = R.drawable.plus_solid),
              contentDescription = null,
              modifier = modifier
            )
          }
        }
      }
    }
  }
}

fun getRandomProductList() : List<Product> {
  val listSize = 3
  return productList.asSequence().shuffled().take(listSize).toList()
}

fun getProductListFrom(supermarket: Supermarket) : List<Product> {
  val listSize = 3
  val copiedList = productList.map{ it.copy() }
  val list = copiedList.toMutableList()
  list.removeIf { it.supermarket != supermarket }
  return list.asSequence().shuffled().take(listSize).toList()
}

fun getRandomOffers() : List<Product> {
  val listSize = 3
  val copiedList = productList.map{ it.copy() }
  val list = copiedList.toMutableList()
  list.removeIf { !it.hasOffer }
  return list.asSequence().shuffled().take(listSize).toList()
}

fun getRandomOffersFrom(supermarket: Supermarket) : List<Product> {
  val listSize = 3
  val copiedList = productList.map{ it.copy() }
  val list = copiedList.toMutableList()
  list.removeIf { !it.hasOffer || it.supermarket != supermarket }
  return list.asSequence().shuffled().take(listSize).toList()
}

fun getListFromText(text: String) : List<Product> {
  var searchText = text.lowercase()
  val copiedList = productList.map{ it.copy() }
  val list = copiedList.toMutableList()
  list.removeIf {
    !(it.name + it.brand + it.extraInfo + MarketToString(it.supermarket))
      .lowercase()
      .contains(searchText)
  }
  return list.asSequence().shuffled().take(list.size).toList()
}