package com.example.grocerycenter.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.grocerycenter.ui.reusablecomposables.BottomBar
import com.example.grocerycenter.ui.reusablecomposables.MainScreen
import com.example.grocerycenter.ui.reusablecomposables.TopBar

@Composable
fun OffersScreen() {
  MainScreen(
    topBar = { TopBar(name = "Special Offers") },
    bottomBar = { BottomBar() },
    content = {
      Text(text = "Sample Text")
    }
  )
}