package com.example.grocerycenter.ui.reusablecomposables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.grocerycenter.R
import com.example.grocerycenter.data.MarketToDrawable
import com.example.grocerycenter.data.MarketToString
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
    horizontalArrangement = Arrangement.Start,
    modifier = modifier
      .fillMaxWidth()
      .padding(Padding.medium)
      .shadow(elevation = 1.dp)
  ) {
    Spacer(
      modifier = modifier
        .width(1.dp)
    )
    Column(modifier = modifier) {
      Spacer(
        modifier = modifier
          .height(2.5.dp)
      )
      Image(
        painter = painterResource(id = product.image),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = modifier
          .size(150.dp)
          .padding(Padding.none, Padding.none, Padding.medium, Padding.none)
      )
      Spacer(
        modifier = modifier
          .height(1.dp)
      )
    }
    Column(
      modifier = modifier
    ) {
      Text(
        text = product.name,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.SemiBold,
      )
      Text(
        text = product.extraInfo + " • " + product.brand + " • " + MarketToString(product.supermarket),
        style = MaterialTheme.typography.titleSmall,
        color = Color.LightGray,
        fontWeight = FontWeight.SemiBold,
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
              text = "$" + product.discountedPrice.toString() + "  ",
              style = MaterialTheme.typography.titleLarge,
              color = MaterialTheme.colorScheme.inversePrimary,
              fontWeight = FontWeight.SemiBold,
            )
          }
          Text(
            text = "$" + product.price.toString(),
            style = if (product.hasOffer) MaterialTheme.typography.titleSmall else MaterialTheme.typography.titleLarge,
            color = if (product.hasOffer) Color.LightGray else MaterialTheme.colorScheme.inversePrimary,
            fontWeight = FontWeight.Bold,
            textDecoration = if (product.hasOffer) TextDecoration.LineThrough else TextDecoration.None,
          )
        }
        Button(
          colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error),
          shape = RoundedCornerShape(35),
          contentPadding = PaddingValues(0.dp),
          onClick = {

          },
          modifier = modifier
            .padding(Padding.none, Padding.large, Padding.large, Padding.none)
            .height(30.dp)
            .width(50.dp)
        ) {
          Icon(
            painter = painterResource(id = R.drawable.minus_solid),
            contentDescription = null,
            modifier = modifier
          )
        }
      }
    }
  }
}