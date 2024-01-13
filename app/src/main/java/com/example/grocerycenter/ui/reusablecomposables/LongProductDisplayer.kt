package com.example.grocerycenter.ui.reusablecomposables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.grocerycenter.data.MarketToDrawable
import com.example.grocerycenter.data.Product
import com.example.grocerycenter.ui.state.AppViewModel
import com.example.grocerycenter.ui.theme.Padding

@Composable
fun LongProductDisplayer(
  product: Product,
  viewModel: AppViewModel,
  navigateToProduct: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
      .fillMaxWidth()
      .padding(Padding.medium)
      .shadow(elevation = 3.dp)
  ) {
    Image(
      painter = painterResource(id = product.image),
      contentDescription = null,
      modifier = modifier
        .fillMaxHeight()
        .size(150.dp)
    )
    Column {
      Text(
        text = product.name,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.SemiBold,
      )
      Text(
        text = product.brand + ' ' + product.extraInfo,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold,
      )
      Image(
        painter = painterResource(id = MarketToDrawable(product.supermarket)),
        contentDescription = null,
        modifier = modifier
          .height(35.dp)
          .padding(Padding.none)
      )
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
          .fillMaxWidth()
      ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
          Text(
            text = "$" + product.price.toString(),
            style = if (product.hasOffer) MaterialTheme.typography.titleSmall else MaterialTheme.typography.titleLarge,
            color = if (product.hasOffer) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.inversePrimary,
            fontWeight = FontWeight.Bold,
            textDecoration = if (product.hasOffer) TextDecoration.LineThrough else TextDecoration.None,
          )
          if (product.hasOffer) {
            Text(
              text = " $" + product.discountedPrice.toString(),
              style = MaterialTheme.typography.titleLarge,
              color = MaterialTheme.colorScheme.inversePrimary,
              fontWeight = FontWeight.Bold,
            )
          }
        }
      }
    }
  }
}