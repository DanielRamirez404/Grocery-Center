package com.example.grocerycenter.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.grocerycenter.R
import com.example.grocerycenter.data.Product
import com.example.grocerycenter.ui.state.AppViewModel
import com.example.grocerycenter.ui.screens.CompareScreen
import com.example.grocerycenter.ui.screens.HomeScreen
import com.example.grocerycenter.ui.screens.OffersScreen
import com.example.grocerycenter.ui.screens.OptionsScreen
import com.example.grocerycenter.ui.screens.ProductScreen
import com.example.grocerycenter.ui.screens.SearchScreen
import com.example.grocerycenter.ui.theme.Padding

enum class Screens(title: String) {
  Compare(title = "Compare"),
  Home(title = "Home"),
  Offers(title = "Offers"),
  Search(title = "Search"),
  Options(title = "Options"),
  Products(title = "Products")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
  viewModel: AppViewModel = viewModel(),
  navController: NavHostController = rememberNavController(),
  modifier: Modifier = Modifier
) {
  Scaffold(
    topBar = { TopBar("Example") },
    bottomBar = {
      BottomBar(
        onHomeClick = { navController.navigate(Screens.Home.name) },
        onCompareClick = { navController.navigate(Screens.Compare.name) },
        onSearchClick = { navController.navigate(Screens.Search.name) },
        onOffersClick = { navController.navigate(Screens.Offers.name) },
        onOptionsClick = { navController.navigate(Screens.Options.name) }
      )
    },
    modifier = modifier
  ) {
    val uiState by viewModel.uiState.collectAsState()
    NavHost(
      navController = navController,
      startDestination = Screens.Home.name,
      modifier = modifier.padding(it)
    ) {
      composable(route = Screens.Compare.name) {
        CompareScreen()
      }
      composable(route = Screens.Home.name) {
        HomeScreen(
          navigateToProduct = {
            navController.navigate(Screens.Products.name)
          },
          viewModel = viewModel
        )
      }
      composable(route = Screens.Offers.name) {
        OffersScreen()
      }
      composable(route = Screens.Search.name) {
        SearchScreen()
      }
      composable(route = Screens.Options.name) {
        OptionsScreen()
      }
      composable(
        route = Screens.Products.name,
      ) {
        ProductScreen(viewModel = viewModel)
      }
    }
  }
}

@Composable
fun BottomBar(
  onHomeClick: () -> Unit,
  onCompareClick: () -> Unit,
  onSearchClick: () -> Unit,
  onOffersClick: () -> Unit,
  onOptionsClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    horizontalArrangement = Arrangement.SpaceEvenly,
    modifier = modifier
      .fillMaxWidth()
      .background(color = MaterialTheme.colorScheme.primary)
  ) {
    BottomBarItem(
      icon = R.drawable.house,
      text = Screens.Home.name,
      onClick = { onHomeClick() }
    )
    BottomBarItem(
      icon = R.drawable.scale,
      text = Screens.Compare.name,
      onClick = { onCompareClick() }
    )
    BottomBarItem(
      icon = R.drawable.magnifying_glass,
      text = Screens.Search.name,
      onClick = { onSearchClick() }
    )
    BottomBarItem(
      icon = R.drawable.tag,
      text = Screens.Offers.name,
      onClick = { onOffersClick() }
    )
    BottomBarItem(
      icon = R.drawable.ellipsis,
      text = Screens.Options.name,
      onClick = { onOptionsClick() }
    )
  }
}

@Composable
fun BottomBarItem(
  icon: Int,
  text: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Button(
    onClick = onClick,
    modifier = modifier
      .height(Padding.larger)
  ) {
    Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = modifier
    ) {
      Icon(painter = painterResource(id = icon), contentDescription = text)
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(name: String, modifier: Modifier = Modifier) {
  CenterAlignedTopAppBar(
    modifier = modifier,
    title = {
      Text(text = "Grocery Center")
    }
  )
}