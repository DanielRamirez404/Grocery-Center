package com.example.grocerycenter.ui.reusablecomposables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.example.grocerycenter.data.Product
import com.example.grocerycenter.ui.theme.Padding

@Composable
fun ProductDisplayer(product: Product, modifier: Modifier = Modifier) {
  val width = 175.dp
  Column(
    modifier = modifier
      .padding(Padding.medium, Padding.none)
      .width(width)
      .shadow(elevation = 3.dp)

  ) {
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
    ) {
      Text(text = product.name)
      Text(text = product.brand)
      Text(text = "$ " + product.price.toString())
    }
  }
}