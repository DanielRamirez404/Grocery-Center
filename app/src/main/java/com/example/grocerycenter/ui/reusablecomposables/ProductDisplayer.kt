package com.example.grocerycenter.ui.reusablecomposables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grocerycenter.data.MarketToDrawable
import com.example.grocerycenter.data.Product
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
        Text(
          text = "$ " + product.price.toString(),
          style = MaterialTheme.typography.bodyLarge,
          color = MaterialTheme.colorScheme.inversePrimary,
          fontWeight = FontWeight.Bold
        )
      }
    }
  }
}