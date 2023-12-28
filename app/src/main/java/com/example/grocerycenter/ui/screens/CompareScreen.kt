package com.example.grocerycenter.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.grocerycenter.data.productList
import com.example.grocerycenter.ui.reusablecomposables.BottomBar
import com.example.grocerycenter.ui.reusablecomposables.MainScreen
import com.example.grocerycenter.ui.reusablecomposables.TopBar

@Composable
fun CompareScreen() {
  MainScreen(
    topBar = { TopBar(name = "Compare Products") },
    bottomBar = { BottomBar() },
    content = {
      Text(text = "Sample Text")
    }
  )
}