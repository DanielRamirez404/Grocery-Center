package com.example.grocerycenter.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableInferredTarget
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.grocerycenter.R
import com.example.grocerycenter.ui.reusablecomposables.LongProductDisplayer
import com.example.grocerycenter.ui.state.AppViewModel
import com.example.grocerycenter.ui.theme.Padding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
  viewModel: AppViewModel,
  navigateToProduct: () -> Unit,
  modifier: Modifier = Modifier
) {
  var text by remember { mutableStateOf("") }
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center,
      modifier = modifier
        .fillMaxWidth()
    ) {
      OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(
          text = "Search",
          color = MaterialTheme.colorScheme.outline
        ) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
          keyboardType = KeyboardType.Ascii,
          imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
          onSearch = {
            viewModel.searchProduct(text)
          }
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
          focusedBorderColor = Color.LightGray,
          unfocusedBorderColor = Color.LightGray
        ),
        modifier = modifier
          .padding(start = Padding.small)
      )
      Button(
        colors = ButtonDefaults.buttonColors(Color.Gray),
        shape = RoundedCornerShape(20),
        contentPadding = PaddingValues(0.dp),
        onClick = {
          viewModel.searchProduct(text)
        },
        modifier = modifier
          .size(width = 75.dp, 55.dp)
          .padding(start = Padding.medium, top = 5.dp)
      ) {
        Icon(
          painter = painterResource(id = R.drawable.magnifying_glass),
          contentDescription = null,
          modifier = modifier
        )
      }
    }
    if (viewModel.searchList.size > 0) {
      LazyColumn(
        modifier = modifier
          .fillMaxWidth()
      ) {
        items(viewModel.searchList) {
          LongProductDisplayer(
            product = it,
            viewModel = viewModel,
            navigateToProduct = navigateToProduct,
            modifier = modifier
          )
        }
      }
    }
  }
}