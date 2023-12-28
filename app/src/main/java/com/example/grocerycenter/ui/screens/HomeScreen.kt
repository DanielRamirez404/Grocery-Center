package com.example.grocerycenter.ui.screens

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.grocerycenter.data.productList
import com.example.grocerycenter.ui.reusablecomposables.BottomBar
import com.example.grocerycenter.ui.reusablecomposables.MainScreen

@Composable
fun HomeScreen() {
  MainScreen(
    topBar = { HomeTopBar() },
    bottomBar = { BottomBar() },
    content = {
      Text(text = productList[0].name + " " + productList[0].brand)
    }
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
  CenterAlignedTopAppBar(
    title = {
      Text(text = "Grocery Center")
    }
  )
}