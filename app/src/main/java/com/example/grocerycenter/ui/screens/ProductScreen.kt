package com.example.grocerycenter.ui.screens

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.grocerycenter.R
import com.example.grocerycenter.data.MarketToString
import com.example.grocerycenter.data.Product
import com.example.grocerycenter.ui.state.AppViewModel
import com.example.grocerycenter.ui.theme.Padding

@Composable
fun InfoRow(
  title: String,
  info: String,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier
      .padding(vertical = Padding.medium)
  ) {
    Spacer(modifier = modifier.width(Padding.medium))
    Text(
      text = "$title:",
      style = MaterialTheme.typography.titleMedium,
      modifier = modifier
        .size(75.dp, 25.dp)
    )
    Spacer(modifier = modifier.width(Padding.large))
    Text(
      text = info,
      style = MaterialTheme.typography.bodyLarge,
      modifier = modifier
        .size(155.dp, 25.dp)
    )
    Spacer(modifier = modifier.width(Padding.medium))
  }
}

@Composable
fun ProductScreen(
  viewModel: AppViewModel,
  modifier: Modifier = Modifier
) {
  val uiState = viewModel.uiState.collectAsState()
  val product: Product = uiState.value.selectedProduct
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = modifier
      .verticalScroll(rememberScrollState())
  ) {
    Box(
      
    ) {
      Image(
        contentDescription = null,
        painter = painterResource(product.image),
        contentScale = ContentScale.FillBounds,
        modifier = modifier
          .height(400.dp)
          .background(color = MaterialTheme.colorScheme.background)
          .fillMaxWidth()
      )
      Surface(
        modifier = Modifier
          .height(75.dp)
          .align(Alignment.TopEnd)
          .padding(top = 25.dp)
          .shadow(3.dp),
        shape = RectangleShape) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = modifier
            .padding(end = 25.dp)
        ) {
          Spacer(modifier = modifier.width(Padding.medium))
          if (product.hasOffer) {
            Text(
              text = "$" + product.discountedPrice.toString() + " ",
              style = MaterialTheme.typography.titleLarge,
              color = MaterialTheme.colorScheme.inversePrimary,
              fontWeight = FontWeight.Bold,
            )
          }
          Text(
            text = "$" + product.price.toString(),
            style = if (product.hasOffer) MaterialTheme.typography.titleSmall else MaterialTheme.typography.titleLarge,
            color = if (product.hasOffer) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.inversePrimary,
            fontWeight = FontWeight.Bold,
            textDecoration = if (product.hasOffer) TextDecoration.LineThrough else TextDecoration.None,
          )
        }
      }
    }
    Spacer(modifier = modifier.height(Padding.large))
    Column(
      modifier = modifier
        .drawBehind { drawRoundRect(
          Color(0xFFF7f7f0),
          cornerRadius = CornerRadius(10.dp.toPx())
        ) }
    ) {
      InfoRow(title = "Name", info = product.name)
      InfoRow(title = "Market", info = MarketToString(product.supermarket))
      InfoRow(title = "Brand", info = product.brand)
      InfoRow(title = "Specs", info = product.extraInfo)
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
        .padding(top = Padding.medium + Padding.small)
        .height(40.dp)
        .width(200.dp)
    ) {
      Text(
        text = "Add to List",
        style = MaterialTheme.typography.titleMedium
      )
    }
  }
}